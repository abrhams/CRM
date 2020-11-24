create table manager(
managerID int(11) primary key auto_increment,
username varchar(50) unique,
password varchar(30) not null,
managerName varchar(50) not null,
createDate date not null,
createPersonnel varchar(50),
accessLevel int(3) not null
);

create table customer(
customerID int(11) primary key auto_increment,
customerName varchar(50) not null,
customerAge int(5),
customerPhone varchar(12) not null,
customerGender char(2) not null,
customerQQ varchar(20),
customerWX varchar(20),
staffID int(11),
createDate date,
marketingStatus int(5)
);

create table marketingorder(
marketingOrderID int(11) primary key auto_increment,
staffID int(11) not null,
customerID int(11) not null,
customerDemand varchar(128) not null,
createDate date,
marketingClue int(5),
occasionLevel int(5),
occasionAnalyseContent varchar(128),
activityTrackingTimes int(11)
);

create table sellorder(
sellID int(11) primary key auto_increment,
staffID int(11) not null,
customerID int(11) not null,
sellDate date,
sellPrice double(18,2),
payStatus int(5),
payType varchar(10),
payTime date 
);

create table serviceorder(
serviceID int(11) primary key auto_increment,
customerID int(11) not null,
staffID int(11) not null,
createDate date not null,
serviceType int(5) not null,
serviceContent varchar(128),
serviceFeeback varchar(128)
);

create table staff(
staffID int(11) primary key auto_increment,
username varchar(50) unique,
password varchar(50) not null,
staffName varchar(50) not null,
staffPhone varchar(12) not null,
staffAge int(5),
staffGender char(2),
staffQQ varchar(20),
staffWX varchar(20),
marketingLevel int(5) not null,
CompanyDate date,
DepID int(11),
superiorID int(11),
staffPosition varchar(20),
staffLevel int(5),
staffSalary double(18,2),
commissionRate double(5,2)
);