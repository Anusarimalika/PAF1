<%@page import="model.Patients"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Management </title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.5.0.min.js"></script> 
<script src="Components/patientss.js"></script>
</head>
<body>

  <div class="container"> 
  <div class="row">
  <div class="col-6">
  
    <h1>Patient Management </h1>
    
    <form id="formPatient" name="formPatient"> 
          Patient FirstName:
          <input id="pFname" name="pFname" type="text" class="form-control form-control-sm">
          
         <br> Patient LastName:
         <input id="pLname" name="pLname" type="text" class="form-control form-control-sm">
         
         <br> Patient NIC:
        <input id="pNIC" name="pNIC" type="text" class="form-control form-control-sm">
        
        <br> Patient Address:
        <input id="pAddress" name="pAddress" type="text" class="form-control form-control-sm">
        
         				<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
					    <span class="input-group-text" id="pGender">
							
					Gender: </span>
						</div>
						&nbsp;&nbsp;Male <input type="radio" id="rdoGenderMale"
							name="pGender" value="Male"> &nbsp;&nbsp;Female <input
							type="radio" id="rdoGenderFemale" name="pGender" value="Female">
					</div>
         <br> Patient Email:
        <input id="pEmail" name="pEmail" type="text" class="form-control form-control-sm">
        
        <br> Patient Age:
        <input id="pAge" name="pAge" type="text" class="form-control form-control-sm">
        
        <br> Patient Phone:
        <input id="pPhone" name="pPhone" type="text" class="form-control form-control-sm">
        
        <br> Patient Admitted:
        <input id="pAdmitted" name="pAdmitted" type="text" class="form-control form-control-sm">
       <br>
       
        <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> 
        
        <input type="hidden" id="hidPatientIDSave" name="hidPatientIDSave" value="">
        </form>
        
        <div id="alterSuccess" class="alter alter-succes"></div>
        <div id="alterError" class="alter alter-danger"></div>
        <br>
           <div id="divPatientssGrid">
           
           <%
             
       	       Patients patiObj = new Patients();
              out.print(patiObj.readPatients());

 
           %>
           
        </div>
           </div>
                </div>
                     </div>
           
        
        
    

</body>
</html>