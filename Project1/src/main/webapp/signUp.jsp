<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>

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
				
				
	<div class="formChecker d-flex align-items-center justify-content-center">

		<div class="container col-sm-12 col-md-8 col-lg-4 m-1">

			<!-- Pills navs -->
			<ul class="nav nav-pills nav-justified mb-3 ml-0" id="ex1"
				role="tablist">
				
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="tab-register" data-mdb-toggle="pill" href="#pills-register"
					role="tab" aria-controls="pills-register" aria-selected="false">Register</a>
				</li>
			</ul>
				<!---------------------  FORM  ------------------------->
					<form method="post" action="signUp">

						<!-- Name input -->
						<div class="form-outline mb-4">
							<input type="text" name="registerName" id="registerName" class="form-control" /> <label
								class="form-label" for="registerName">Name</label>
						</div>

						<!-- Username input -->
						<div class="form-outline mb-4">
							<input type="text" name="registerUsername" id="registerUsername" class="form-control" />
							<label class="form-label" for="registerUsername">Username</label>
						</div>
						
						<!-- ----- JOB TYPE OPTION  -->
							<b>Position:</b> <br>
							<select name="jobType">
								<option value="ARCHITECT" selected>ARCHITECT</option>
  								<option value="TEHNICIAN" >TEHNICIAN</option>
  								<option value="PROJECT_MANAGER">PROJECT_MANAGER</option>
  								<option value="CIVIL_ENGINEER">CIVIL_ENGINEER</option>
							</select>
							<br><br>

						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="email" name="registerEmail" id="registerEmail" class="form-control" /> <label
								class="form-label" for="registerEmail">Email</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
							<input type="password" name="registerPassword" id="registerPassword" class="form-control" />
							<label class="form-label" for="registerPassword">Password</label>
						</div>

						<!-- Repeat Password input -->
						<div class="form-outline mb-4">
							<input type="password" name="registerPasswordRepeat" id="registerRepeatPassword"
								class="form-control" /> <label class="form-label"
								for="registerRepeatPassword">Repeat password</label>
						</div>
						

						<!-- Checkbox -->
						<div class="form-check d-flex justify-content-center mb-4">
							<input class="form-check-input me-2" type="checkbox" value=""
								id="registerCheck" 
								aria-describedby="registerCheckHelpText" /> <label
								class="form-check-label" for="registerCheck"> I have
								read and agree to the terms </label>
						</div>

						<!-- Submit button -->
						<button type="submit" name="action" value="signUp" class="btn btn-primary btn-block mb-3">REGISTER NOW
							</button>
					</form>
					<!------------------ </FORM> ------------------------>
					
					<div>
						<a href="login.jsp" style="text-decoration: underline;">Already registered? Please LOG IN here.</a>
					</div>
					
					<br>
					<span style="color: red; font-size: 16px;">${requestScope.signUpErrorMsg}</span>
					 
		</div>
	</div>
	<!-- Pills content -->

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</body>
</html>