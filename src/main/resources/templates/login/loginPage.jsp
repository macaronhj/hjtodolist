<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Login Page</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <script>
        $(document).ready(function () {

            //게시글 수정 페이지 이동
            $(".requestLogin").on("click", function () {
                $.post("/login/requestLogin", {function (data) {
                        alert(data);
                    });
            });
            });
        });
    </script>
</head>
<body class="text-center">

<main class="form-signin">
    <form>
        <img class="mb-4" src="/img/logo2.png">
        <h1 class="h3 mb-3 fw-normal">Login</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" name="email">
            <label for="floatingInput">이메일을 입력해주세요.</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="pwd">
            <label for="floatingPassword">비밀번호를 입력해주세요.</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary requestLogin" type="submit">Login</button>
        <p class="mt-5 mb-3 text-muted">ToDoList</p>
    </form>
</main>
</body>
</html>