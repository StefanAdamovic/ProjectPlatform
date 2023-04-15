<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Platform Login</title>


<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
	rel="stylesheet" />

<link href="style.css" rel="stylesheet">

</head>
<body>

	<div
		class="formChecker d-flex align-items-center justify-content-center">

		<div class="container col-sm-12 col-md-8 col-lg-4 m-1">

			<!-- Pills navs -->
			<ul class="nav nav-pills nav-justified mb-3 ml-0" id="ex1"
				role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" id="tab-login" data-mdb-toggle="pill"
					href="#pills-login" role="tab" aria-controls="pills-login"
					aria-selected="true">Login</a></li>
			</ul>

				<!---------------------  FORM  ------------------------->
					<form method="post" action="login">

						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" name="username" id="loginName" class="form-control" /> <label
								class="form-label"   for="loginName">Username</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
							<input type="password" name="password" id="loginPassword" class="form-control" />
							<label class="form-label"  for="loginPassword">Password</label>
						</div>

						<!-- 2 column grid layout -->
						<div class="row mb-4">
							<div class="col-md-6 d-flex justify-content-center">
								<!-- Checkbox -->
								<div class="form-check mb-3 mb-md-0">
									<input class="form-check-input" type="checkbox" value=""
										id="loginCheck"  /> <label class="form-check-label"
										for="loginCheck"> Remember me </label>
								</div>
							</div>

							<div class="col-md-6 d-flex justify-content-center">
								<!-- Simple link -->
								<a href="#!">Forgot password?</a>
							</div>
						</div>

						<!-- Submit button -->
						<button type="submit" name="action" value="login" class="btn btn-primary btn-block mb-4">LOG IN</button>
					</form>
					
					<div>
						<a href="signUp.jsp" style="text-decoration: underline;">Not registered user? Go to REGISTER page.</a>
					</div>
					
					<!------------------ </FORM> ------------------------>
					<br>
					
					<span style="color: red; font-size: 16px;">${requestScope.errorMsg}</span>
					<span style="color: green; font-size: 16px;">${requestScope.signUpSuccess}</span> 
		</div>
	</div>
	<!-- Pills content -->

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>

</body>
</html>



