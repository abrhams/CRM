function total_manager(){
	/**
	 * 管理员
	 */
	layui.use('table', function(){
	  var table = layui.table;
	  
	  // 管理员数据渲染
	  table.render({
	    elem: '#data_manager'
	    ,url: 'queryPage.mdo'
	    ,cols: [[
	      {checkbox: true, fixed: true}
	      ,{field:'managerID', title: 'ID', width:100, sort: true, fixed: true}
	      ,{field:'username', title: '用户名', width:150}
	      ,{field:'managerName', title: '管理员名字', width:150, sort: true}
	      ,{field:'createDate', title: '创建时间', sort: true,width:150}
	      ,{field:'createPersonnel', title: '创建人',width:150}
	      ,{field:'accessLevel', title: '权限等级', sort: true, width:150}
	      ,{fixed:'right',align:'center',toolbar:'#bar_btn'}
	    ]]
	    ,id: 'Reload_manager'
	    ,page: true
	    ,height: 310
	    ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
	  });
	  
	  // 重载管理员
	  var $ = layui.$, active = {
	    reload: function(){
	    var demoReload = $('#Reload_m');
	    console.log(demoReload.val());
	    //执行重载
	    table.reload('Reload_manager', {
	        url:"queryByID.mdo"      	
	       ,page: {curr: 1}//重新从第 1 页开始
	       ,where: {managerID: demoReload.val()}
	       }, 'data');
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	  
	//监听头工具栏事件
	  /*table.on('toolbar(manager)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
	    switch(obj.event){
	      case 'add':
	        layer.msg('添加');
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
	  });*/

	  //监听行工具事件
	  table.on('tool(manager)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
	    var data = obj.data //获得当前行数据
	    ,layEvent = obj.event; //获得 lay-event 对应的值
	    if(layEvent === 'add'){
	      layer.msg('添加管理员');
	      layer.open({
	          type: 2 //此处以iframe举例
	          ,title: '添加操作'
	          ,area: ['590px', '460px']
	          ,shade: 0
	          ,maxmin: true
	          /*,offset: [ //为了演示，随机坐标
	            Math.random()*($(window).height()-300)
	            ,Math.random()*($(window).width()-390)
	          ] */
	          ,content: './addmanager.html'
	          ,btn: ['确认', '取消'] // 按钮
	          ,yes: function(index, layero){
	        	  //layer.iframeAuto(index)
	        	 /* var body = layer.getChildFrame('body', index);
	        	  var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	        	  console.log(body.html()) //得到iframe页的body内容
	        	  body.find('input').val('Hi，我是从父页来的')*/
	        	  var body = layer.getChildFrame('body', index);
	        	  var iframeWin = window[layero.find('iframe')[0]['name']];
	        	  console.log(body.find("#user").val());
	              $(this).click();
	            // 添加管理员
	        	  $.ajax({
	                  url:'http://localhost:8080/CRM/addManager.mdo',
	                  type:'post',
	                  dataType:'json',
	                  data:{
	                      username:body.find('#user').val(),
	                      password:body.find('#pwd').val(),
	                      managerName:body.find('#managername').val(),
	                      createPersonnel:body.find('#createpl').val(),
	                      accessLevel:body.find("#accesslevel option:selected").val()
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
	      
	    } else if(layEvent === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        //obj.del(); //删除对应行（tr）的DOM结构
	        //layer.close(index);
	        //向服务端发送删除指令
	        console.log(data.managerID);
	        $.ajax({
	        	url:"deleteManager.mdo",
	        	type:"post",
	        	data:{
	        		managerID:data.managerID
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
	          ,area: ['590px', '460px']
	          ,shade: 0
	          ,maxmin: true
	          /*,offset: [ //为了演示，随机坐标
	            Math.random()*($(window).height()-300)
	            ,Math.random()*($(window).width()-390)
	          ] */
	          ,content: './addmanager.html'
	          ,btn: ['确认', '取消'] // 按钮
	          ,yes: function(index, layero){
	        	  layer.iframeAuto(index)
	        	 /* var body = layer.getChildFrame('body', index);
	        	  var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	        	  console.log(body.html()) //得到iframe页的body内容
	        	  body.find('input').val('Hi，我是从父页来的')*/
	        	  var body = layer.getChildFrame('body', index);
	        	  var iframeWin = window[layero.find('iframe')[0]['name']];
	        	  //console.log(data);
	        	  // console.log(body.find("#user").val());
	              $(this).click();
	              // 编辑管理员
	        	  $.ajax({
	                  url:'http://localhost:8080/CRM/updateManager.mdo',
	                  type:'post',
	                  dataType:'json',
	                  data:{
	                      managerID:data.managerID,                 	  
	                      username:body.find('#user').val(),
	                      password:body.find('#pwd').val(),
	                      managerName:body.find('#managername').val(),
	                      createPersonnel:body.find('#createpl').val(),
	                      accessLevel:body.find("#accesslevel option:selected").val()
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
	                      //layer.closeAll();
	                      setTimeout(function(){
	                           layer.closeAll();
	                       }, 3000);
	                  }
	              }); 
	          }
	          ,btn2: function(){
	            layer.closeAll();
	          }
	          //,zIndex: layer.zIndex //重点1
	          ,success: function(layero, index){
	            //layer.setTop(layero); //重点2
	        	//找到它的子窗口的body
	            var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
	            //为子窗口元素赋值
	            body.contents().find("#user").val(data.username);
	            body.contents().find("#pwd").val(data.password);
	            body.contents().find("#rpwd").val(data.password);
	            body.contents().find("#managername").val(data.managerName);
	            body.contents().find("#createpl").val(data.createPersonnel);
	            body.contents().find("#accesslevel").val(data.accessLevel);
	            console.log(data)
	          }
	        });
	      
	    }
	  });
	  
	});
}


function reloadData(){
    //当前页的刷新
    $(".layui-laypage-btn")[0].click();
}