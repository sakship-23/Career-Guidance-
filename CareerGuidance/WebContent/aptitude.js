function check(){
	
	
	var science=0;
	var arts=0;
	var commerce=0;
	
	
	var q1=document.aptitude.question1.value;
	var q2=document.aptitude.question2.value;
	var q3=document.aptitude.question3.value;
	var q4=document.aptitude.question4.value;
	var q5=document.aptitude.question5.value;
	var q6=document.aptitude.question6.value;
	var q7=document.aptitude.question7.value;
	var q8=document.aptitude.question8.value;
	var q9=document.aptitude.question9.value;
	var q10=document.aptitude.question10.value;
	var q11=document.aptitude.question11.value;
	var q12=document.aptitude.question12.value;
	var q13=document.aptitude.question13.value;
    var q14=document.aptitude.question14.value;	
    var q15=document.aptitude.question15.value;
  
    
    if (q1=="Yes") (science++)
	if (q2=="Yes") (science++)
	if (q3=="Yes") (commerce++)
	if (q4=="Yes") (commerce++)
	if (q5=="Yes") (arts++)
	if (q6=="Yes") (arts++)
	if (q7=="Yes") (science++)
	if (q8=="Yes") (commerce++)
	if (q9=="Yes") (arts++)
	if (q10=="Yes") (science++)
	if (q11=="Yes") (commerce++)
	if (q12=="Yes") (arts++)
	if (q13=="Yes") (science++)
	if (q14=="Yes") (commerce++)
	if (q15=="Yes") (arts++)
	
	localStorage.setItem("science", science);
	localStorage.setItem("commerce", commerce);
	localStorage.setItem("arts", arts);
	location.replace("http://localhost:8080/CareerGuidance/bar.html")
	
	
	
}


