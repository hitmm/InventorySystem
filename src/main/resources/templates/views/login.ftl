<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Material Admin by Bootstrapious.com</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="/static/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="/static/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="/static/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="/static/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="/static/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="/static/img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>企业进销存管理系统</h1>
                            </div>
                            <p>Enterprise Purchase, Sale and Inventory Management System</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="/index" class="form-validate">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="userName" required
                                           data-msg="Please enter your username" class="input-material">
                                    <label for="login-username" class="label-material">User Name</label>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required
                                           data-msg="Please enter your password" class="input-material">
                                    <label for="login-password" class="label-material">Password</label>
                                </div>
                                <input id="login" type="submit" class="btn btn-primary" value="Login">

                            </form>
                            <a href="#" class="forgot-pass">Forgot Password?</a><br>
                            <small>Do not have an account?</small>
                            <a href="/register" class="signup">Signup</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyrights text-center">
        <p>Design by <a href="#" class="external">Ambigu</a>
            <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
    </div>
</div>
<!-- JavaScript files-->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/popper.js/umd/popper.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="/static/vendor/chart.js/Chart.min.js"></script>
<script src="/static/vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="/static/js/front.js"></script>
</body>
</html>