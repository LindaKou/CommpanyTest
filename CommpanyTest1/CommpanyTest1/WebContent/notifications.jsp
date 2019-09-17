<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.CommpanyTest1.model.Company"%>
    <%@page import="com.CommpanyTest1.dao.CompanyDao"%>
    <%@page import="java.util.List"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>企业图谱测试</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
    <div class="wrapper ">
        <div class="sidebar" data-color="orange">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
            <div class="logo">
                <a href="#" class="simple-text logo-mini">
                   	 企业
                </a>
                <a href="#" class="simple-text logo-normal">
                   	 图谱分析测试
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li>
                        <a href="notifications.jsp">
                            <i class="now-ui-icons design_app"></i>
                            <p>公司信息</p>
                        </a>
                    </li>
                   
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
                <div class="container-fluid">
                    <div class="navbar-wrapper">
                        <div class="navbar-toggle">
                            <button type="button" class="navbar-toggler">
                                <span class="navbar-toggler-bar bar1"></span>
                                <span class="navbar-toggler-bar bar2"></span>
                                <span class="navbar-toggler-bar bar3"></span>
                            </button>
                        </div>
                        <a class="navbar-brand" href="#pablo"></a>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <form>
                            <div class="input-group no-border">
                            <form action="notification.jsp">
                                <input type="text" value="" name="name" class="form-control" placeholder="请输入企业名称">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                                </span>
                            </form>
                            </div>
                        </form>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <i class="now-ui-icons media-2_sound-wave"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Stats</span>
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="now-ui-icons location_world"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Some Actions</span>
                                    </p>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <i class="now-ui-icons users_single-02"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block">Account</span>
                                    </p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="panel-header">
                <div class="header text-center">
                    <h2 class="title">企业图谱分析</h2>
                   
                    </p>
                </div>
            </div>
             <%
        CompanyDao cdao=new CompanyDao();
        String name=request.getParameter("name");
        List<Company> cs=cdao.load(name);
          
        int i=0;
           for(Company c:cs)
           {
        	   if(i%2==0)
        	   {
        	   %>
            <div class="content">
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header">
                            <div class="card-title">
                             <td ><a href="tables.jsp?name=<%=c.getCORP_NAME() %>">企业名称:<%=c.getCORP_NAME() %></a></td>
                            </div>
                                
                            </div>
                            <div class="card-body">
                                <div class="alert alert-info">
                                    <span>法定代表人:<%=c.getOPER_MAN_NAME() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>成立日期:<%=c.getSTART_DATE() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>注册资本:<%=c.getREG_CAPI() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>企业类型:<%=c.getECON_KIND() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>统一社会信用代码:<%=c.getREG_NO() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>经营范围:<%=c.getFARE_SCOPE() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>公司地址:<%=c.getADDR() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>登记机关:<%=c.getBELONG_ORG() %></span>
                                </div>
                                </div>
                            </div>
                        </div>
                    
                    <%}
        	   else 
        	   {%>
              
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header">
                              <div class="card-title">
                             <td><a href="tables.jsp?name=<%=c.getCORP_NAME() %>">企业名称:<%=c.getCORP_NAME() %></a></td>
                            </div>
                            </div>
                            <div class="card-body">
                                <div class="alert alert-info">
                                    <span>法定代表人:<%=c.getOPER_MAN_NAME() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>成立日期:<%=c.getSTART_DATE() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>注册资本:<%=c.getREG_CAPI() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>企业类型:<%=c.getECON_KIND() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>统一社会信用代码:<%=c.getREG_NO() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>经营范围:<%=c.getFARE_SCOPE() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>公司地址:<%=c.getADDR() %></span>
                                </div>
                                  <div class="alert alert-info">
                                    <span>登记机关:<%=c.getBELONG_ORG() %></span>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
              	   <%
        	   }
        	   i++;
           }
           
        %>
            
        </div>
    </div>
</body>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->

<!-- Chart JS -->
<script src="assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="assets/js/now-ui-dashboard.js?v=1.0.1"></script>
<!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/demo/demo.js"></script>

</html>
