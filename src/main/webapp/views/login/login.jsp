<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
       <section>
        <div class="form-box">
            <div class="form-value">
                <form action="/login1" method="post">
                    <h2>Login</h2>
                    
                    <div class="inputbox">
                        <i class="bi bi-envelope-fill"></i>
                        <input name="email" type="text" required>
                        <label for="">Email</label>
                    </div>
                    <div class="inputbox">
                        <i class="bi bi-lock-fill"></i>
                        <input name="password"  type="password" required>
                        <label for="">Password</label>
                    </div>
                    <div style="font-weight:bold;color:white"><input type="checkbox" >Remember Me  </div>
                    <div class="forget">
                        <a href="#">Forget Password</a>
                    </div>
                    <div style="text-align: center;">
                    <span style="color: red">${message }</span>
                    </div>
                    <button >Log in</button>
                    <div class="register">
                        <p>Don't have a account <a href="/register">Register</a></p>
                    </div>
                </form>

            </div>
        </div>

    </section>
</body>
</html>