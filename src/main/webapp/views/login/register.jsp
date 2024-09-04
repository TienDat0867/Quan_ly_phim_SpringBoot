<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
    <section>
        <div class="form-box">
            <div class="form-value">
                <form action="/DangKy" method="post">

                    <h2>Register</h2>
                    <div class="inputbox">
                        <i class="bi bi-envelope-fill"></i>
                        <input name="email" type="email" required>
                        <label for="">Email</label>
                    </div>
                    <div class="inputbox">
                        <i class="bi bi-lock-fill"></i>
                        <input name="password" type="password" required>
                        <label for="">Password</label>
                    </div>
                    <div class="inputbox">
                        <i class="bi bi-arrow-counterclockwise"></i>
                        <input name="forgotPass" type="password" required>
                        <label for="">Enter the password</label>
                    </div>
                    <div style="text-align: center;">
                    <span style="color: red ">${message}</span>
                    </div>
                    <br>
                    <button>Register</button>
                    <div class="register">
                        <p>Do you want <a href="/login">Log in</a></p>
                    </div>
                </form>

            </div>
        </div>

    </section>
</body>
</html>