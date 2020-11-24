function total_customer(){
	/**
	 * 管理员
	 */
	layui.use('table', function(){
	  var table = layui.table;
	  //
	  
	  // 管理员数据渲染
	  table.render({
	    elem: '#data_customer'
	    ,url: 'queryPageC.cdo'
	    ,cols: [[
	      {checkbox: true, fixed: true}
	      ,{field:'customerID', title: '客户ID', width:100, sort: true, fixed: true}
	      ,{field:'customerName', title: '客户名字', width:100}
	      ,{field:'customerAge', title: '客户年龄', width:100, sort: true}
	      ,{field:'customerPhone', title: '客户电话号码', sort: true,width:150}
	      ,{field:'customerGender', title: '客户性别',width:100}
	      ,{field:'customerQQ', title: '客户QQ', sort: true, width:120}
	      ,{field:'customerWX', title: '客户微信', sort: true, width:120}
	      ,{field:'staffID', title: '营销人员ID', sort: true, width:120}
	      ,{field:'createDate', title: '创建时间', sort: true, width:100}
	      ,{field:'marketingStatus', title: '营销机会', sort: true, width:100}
	      ,{fixed:'right',align:'center',toolbar:'#bar_btn'}
	    ]]
	    ,id: 'Reload_customer'
	    ,page: true
	    ,height: 310
	    ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
	    	 ,where:{token:3121,famd:465}	  
		  /*,request:{
			  famd:111,
			  token:3123
		  }*/
	  // var userid = u_storage.get("userid");// 这个值是要传回服务器，才能判断你曾经登录过了
		// if(userid == undefined)userid="";
		  ,headers:{
			  userid:1111,
			  token:'aaaa'
		  }
	  });
	  
	  /*table.render({
		  //elem:'#data_customer'
		  url:'/api/data'
		  ,where:{token:3121,famd:465}	  
		  ,request:{
			  famd:111,
			  token:'3123'
		  }
	  });*/
	  
	  // 重载管理员
	  var $ = layui.$, active = {
	    reload: function(){
	    var demoReload = $('#Reload_c');
	    console.log(demoReload.val());
	    //执行重载
	    table.reload('Reload_customer', {
	        url:"queryByIDC.cdo"      	
	       ,page: {curr: 1}//重新从第 1 页开始
	      
	       ,where: {customerID: demoReload.val()}
	       }, 'data');
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	  
	  //监听头工具栏事件
	  table.on('toolbar(customer)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
	    switch(obj.event){
	      case 'add':
	        layer.msg('添加客户');
	        addcustomer(layer);
	        reloadData();
	      break;
	      case 'update':
	        if(data.length === 0){
	          layer.msg('请选择一行');
	        } else if(data.length > 1){
	          layer.msg('只能同时编辑一个');
	        } else {
	          layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
	        }
	      break;
	      case 'delete':
	        if(data.length === 0){
	          layer.msg('请选择一行');
	        } else {
	          layer.msg('删除');
	        }
	      break;
	    };
	  });
	  
	  //监听行工具事件
	  table.on('tool(customer)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
	    var data = obj.data //获得当前行数据
	    ,layEvent = obj.event; //获得 lay-event 对应的值
	    if(layEvent === 'add'){
	    	layer.msg('添加客户');
	    	addcustomer(layer);
	    } else if(layEvent === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        //obj.del(); //删除对应行（tr）的DOM结构
	        //layer.close(index);
	        //向服务端发送删除指令
	        console.log(data.customerID);
	        $.ajax({
	        	url:"deleteCustomer.cdo",
	        	type:"post",
	        	data:{
	        		customerID:data.customerID
	        	},
	        	contentType:"application/x-www-form-urlencoded",
	        	dataType:"json",
	        	success:function(data){
	        		console.log(data);
	        		if(data.flag == true){
	        			layer.close(index);
	        			obj.del();
	        			layer.msg('删除成功！');
	        		}else{
	        			layer.close(index);
	        			layer.msg('删除失败！');
	        		}
	        		reloadData();
	        	},
	        	error:function(){
	        		layer.msg('服务在加载中...');
	        	}
	        });
	        
	      });
	    } else if(layEvent === 'edit'){
	      layer.msg('编辑管理员');
	      layer.open({
	          type: 2 //此处以iframe举例
	          ,title: '编辑操作'
	          ,area: ['690px', '460px']
	          ,shade: 0
	          ,maxmin: true
	          ,content: './addcustomer.html'
	          ,btn: ['确认', '取消'] // 按钮
	          ,yes: function(index, layero){
	        	  var body = layer.getChildFrame('body', index);
	        	  var iframeWin = window[layero.find('iframe')[0]['name']];
	        	  //console.log(data);
	        	  // console.log(body.find("#user").val());
	              $(this).click();
	              // 编辑管理员
	        	  $.ajax({
	                  url:'http://localhost:8080/CRM/updateCustomer.cdo',
	                  type:'post',
	                  dataType:'json',
	                  data:{
	                      customerID:data.customerID,                 	  
	                      customerName:body.find('#customerName').val(),
                          customerAge:body.find('#customerAge').val(),
                          customerPhone:body.find('#customerPhone').val(),
                          customerGender:body.find('#customerGender').val(),
                          customerQQ:body.find("#customerQQ").val(),
                          customerWX:body.find("#customerWX").val(),
                          staffID:body.find("#staffID").val(),
                          /*createDate:date,*/
                          marketingStatus:body.find("#marketingStatus").val()
	                  },
	                  success:function(data){
	                  	  console.log(data);
	                      if (data.flag == true) {
	                          layer.alert('修改成功！');
	                          //刷新表格
	                          setTimeout(function(){
	                              //刷新父页面
	                               parent.reloadData();
	                               var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                               parent.layer.close(index);  // 关闭layer
	                           }, 400);
	                      }else {
	                          layer.alert('修改失败！');
	                      }
	                      setTimeout(function(){
	                           layer.closeAll();
	                       }, 3000);
	                      reloadData();
	                  }
	              }); 
	          }
	          ,btn2: function(){
	            layer.closeAll();
	          }
	          ,success: function(layero, index){
	        	//找到它的子窗口的body
	            var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
	            //为子窗口元素赋值
	            //body.contents().find("#user").val(data.username);
	            body.contents().find('#customerName').val(data.customerName),
	            body.contents().find('#customerAge').val(data.customerAge),
	            body.contents().find('#customerPhone').val(data.customerPhone),
	            body.contents().find('#customerGender').val(data.customerGender),
	            body.contents().find("#customerQQ").val(data.customerQQ),
	            body.contents().find("#customerWX").val(data.customerWX),
	            body.contents().find("#staffID").val(data.staffID),
	            body.contents().find("#createDate").val(data.createDate)
	            body.contents().find("#marketingStatus").val(data.marketingStatus)
	            console.log(data)
	          }
	        });
	      
	    }
	  });
	  
	});
}

//添加客户
function addcustomer(layer){
    layer.open({
        type: 2 
        ,title: '添加操作'
        ,area: ['690px', '460px']
        ,shade: 0
        ,maxmin: true
        ,content: './addcustomer.html'
        ,btn: ['确认', '取消'] // 按钮
        ,yes: function(index, layero){
      	  var body = layer.getChildFrame('body', index);
      	  var iframeWin = window[layero.find('iframe')[0]['name']];
            $(this).click();
            var date = new Date();
            // 添加客户
      	  $.ajax({
                url:'http://localhost:8080/CRM/addCustomer.cdo',
                type:'post',
                dataType:'json',
                data:{
              	    customerName:body.find('#customerName').val(),
                    customerAge:body.find('#customerAge').val(),
                    customerPhone:body.find('#customerPhone').val(),
                    customerGender:body.find('#customerGender').val(),
                    customerQQ:body.find("#customerQQ").val(),
                    customerWX:body.find("#customerWX").val(),
                    staffID:body.find("#staffID").val(),
                    /*createDate:date,*/
                    marketingStatus:body.find("#marketingStatus").val()
                },
                success:function(data){
                	console.log(data);
                    if (data.flag == true) {
                        layer.alert('添加成功！');
                    }else {
                        layer.alert('添加失败！');
                    }
                    //layer.close(index);
                    setTimeout(function(){
                        layer.closeAll();
                    }, 3000);
                    reloadData();
                }
            }); 
        }
        ,btn2: function(){
          layer.closeAll();
        }
        //,zIndex: layer.zIndex //重点1
        ,success: function(layero){
          //layer.setTop(layero); //重点2
        }
      });
}

// 刷新表格
function reloadData(){
    //当前页的刷新
    $(".layui-laypage-btn")[0].click();
}