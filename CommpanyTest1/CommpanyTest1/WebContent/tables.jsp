<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.CommpanyTest1.model.Company"%>
    <%@page import="com.CommpanyTest1.dao.CompanyDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js" ></script>
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
 <%
            CompanyDao cdao=new CompanyDao();
            String cname=request.getParameter("name");
            Company  c=cdao.getCompany(cname);
            
            %>
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
                        <a href="tables.jsp?name=<%=c.getCORP_NAME() %>">
                            <i class="now-ui-icons design_app"></i>
                            <p>详细信息</p>
                        </a>
                    </li>
                    <li>
                        <a href="guquan.jsp?name=<%=c.getCORP_NAME() %>">
                            <i class="now-ui-icons education_atom"></i>
                            <p>股权结构</p>
                        </a>
                    </li>
                    <li>
                        <a href="zupu.jsp?name=<%=c.getCORP_NAME() %>">
                            <i class="now-ui-icons location_map-big"></i>
                            <p>投资族谱</p>
                        </a>
                    </li>
                    <li>
                        <a href="tupu.jsp?name=<%=c.getCORP_NAME() %>">
                            <i class="now-ui-icons ui-1_bell-53"></i>
                            <p>企业图谱</p>
                        </a>
                    </li>
                    <li>
                        <a href="yisi.jsp?name=<%=c.getCORP_NAME() %>">
                            <i class="now-ui-icons users_single-02"></i>
                            <p>疑似关系</p>
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
                        <a class="navbar-brand" href="#pablo">Table List</a>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                        <span class="navbar-toggler-bar navbar-kebab"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <form  action="notifications.jsp">
                            <div class="input-group no-border">
                            
                                <input type="text" value="" name="name" class="form-control" placeholder="请输入企业名称">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                                </span>
                              
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
            <div class="panel-header panel-header-sm">
            </div>
            <div class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title"> 企业详细信息</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class=" text-primary">
                                            <th>
                                                Name
                                            </th>
                                            <th>
                                                Country
                                            </th>
                                            <th>
                                                City
                                            </th>
                                            <th class="text-right">
                                                Salary
                                            </th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    企业名称:<%=c.getCORP_NAME() %>
                                                </td>
                                                <td>
                                                    所属地区:<%=c.getBELONG_DIST_ORG() %>               
                                                </td>
                                                <td>
                                                    注册资金:<%=c.getREG_CAPI() %> 
                                                </td>
                                                <td class="text-right">
                                                  组织机构代码:<%=c.getORG_INST_CODE() %> 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                     法定代表人: <%=c.getOPER_MAN_NAME() %>
                                                </td>
                                                <td>
                                                    所属行业:<%=c.getBELONG_TRADE() %> 
                                                </td>
                                                <td>
                                                    经营期限(起):<%=c.getFARE_TERM_START() %>
                                                </td>
                                                <td class="text-right">
                                                  纳税人识别号:<%=c.getTAXPAY_NUM() %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                  成立日期:<%=c.getSTART_DATE() %>
                                                </td>
                                                <td>
                                                    公司类型:<%=c.getECON_KIND() %>
                                                </td>
                                                <td>
                                                    经营期限(止):<%=c.getFARE_TERM_END() %>
                                                </td>
                                                <td class="text-right">
                                                    人员规模:<%=c.getSTAFF_SIZE() %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    注册资本:<%=c.getREG_CAPI() %>
                                                </td>
                                                <td>
                                                    企业大类:<%=c.getADMIT_MAIN() %>
                                                </td>
                                                <td>
                                                    经营范围:<%=c.getFARE_SCOPE() %>
                                                </td>
                                                <td class="text-right">
                                                    英文名:<%=c.getENGLISH_NAME() %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    企业类型:<%=c.getECON_KIND() %>
                                                </td>
                                                <td>
                                                    成立日期:<%=c.getSTART_DATE() %>
                                                </td>
                                                <td>
                                                    注册号:<%=c.getUNI_SCID() %>
                                                </td>
                                                <td class="text-right">
                                                   曾用名:<%=c.getFORMER_NAME() %> 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                   统一社会信用代码:<%=c.getREG_NO() %>
                                                </td>
                                                <td>
                                                    核准日期:<%=c.getCHECK_DATE() %>
                                                </td>
                                                <td>
                                                    电话:<%=c.getTEL() %>
                                                </td>
                                                <td class="text-right">
                                                    创建时间:<%=c.getCREATE_DATE() %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    经营范围:<%=c.getFARE_SCOPE() %>
                                                </td>
                                                <td>
                                                    法定代表人证件编号:<%=c.getOPER_MAN_IDENT_NO() %>
                                                </td>
                                                <td>
                                                    官网:<%=c.getWEB_URL() %>
                                                </td>
                                                <td class="text-right">
                                                    创建机构代码:<%=c.getCREATE_ORG() %>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    公司地址:<%=c.getADDR() %>
                                                </td>
                                                <td>
                                                    法定代表人名称:<%=c.getOPER_MAN_NAME() %>
                                                </td>
                                                <td>
                                                    邮箱:<%=c.getEMAIL() %>
                                                </td>
                                                <td class="text-right">
                                                    
                                                </td>
                                            </tr>
                                              <tr>
                                                <td>
                                                    登记机关:<%=c.getBELONG_ORG() %>
                                                </td>
                                                <td>
                                                    经营状态:<%=c.getCORP_STATUS() %>
                                                </td>
                                                <td>
                                                   从业人数:<%=c.getPRAC_PERSON_NUM() %>
                                                </td>
                                               <td class="text-right">
                                                    
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
           
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
