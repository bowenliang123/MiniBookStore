<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <!-- Bootstrap -->
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href=".">MiniBookStore 迷你书城</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href=".">Home</a></li>
              <li class="active"><a href="#about">About</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h1>Welcome to MiniBookStore!</h1>
      <h1>欢迎来到迷你书城！</h1>
      <br><br><br>
      <h3>作者：梁博文 Dec2012</h3>
      <br>
      <h4>后端运用的技术包括：Struts2、Hibernate3、Spring3</h4>
      <h4>前段运用的技术包括：BootStrap、jQuery</h4>

    </div>
    
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>