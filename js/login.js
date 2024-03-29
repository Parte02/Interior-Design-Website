
function login(){
    var username= document.getElementById("signinUsername").value;
    var password = document.getElementById("signinPassword").value;
    callLoginBackend(username,password);
  }
  function callLoginBackend(username,password) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"username":"'+username+'","password":"' +password+'"}';
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackLoginBackend( this.responseText);
    }
    
  };
  
  xhttp.open("POST", "http://localhost:8080/Find", true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackLoginBackend(res){
    alert(res)
    const result = JSON.parse(res);
    const adminUsername = "admin123";
    const adminPassword = "admin123";

    var username= document.getElementById("signinUsername").value;
    var password = document.getElementById("signinPassword").value;
   
    
    if (username === adminUsername && password === adminPassword) {
      window.location.href ='registerT.html';
      localStorage.setItem('auth_token',result.token);
     }
    else if(result.errId==-1){
    window.location.href ='index.html';
    localStorage.setItem('auth_token',result.token);
    }
   
    
    else{
      alert("Invalid User")
    } 
    
  }
  

 
  
  function validForm(){
    var u = document.getElementById('signinUsername');
    var p = document.getElementById('signinPassword');
   

    var userError = document.getElementById('userError');
    var passError = document.getElementById('passError');
    var uError = document.getElementById('uError');
    var pError = document.getElementById('pError');
    
    var isValid = true;

    if(u.value ===''){
        u.style.borderColor="red";
        userError.textContent = 'UserName is required!';
        isValid = false;
    }else{
      u.style.borderColor="";
      userError.textContent='';
    }
    if(!/.{6,20}/.test(u.value)){
      uError.textContent = 'Username must be [6,20] symbols and contain only small letters and numbers';
      isValid = false;
    }else{
      u.style.borderColor="";
      uError.textContent = '';
    }

    if(p.value ===''){
      p.style.borderColor="red";
      passError.textContent = 'PassWord is required!';
      isValid = false;
  }
 else if(!/.{6,}/.test(p.value)){
    pError.textContent = 'Password must be more than 6 symbols';
    isValid = false;
    return false;
  }else{
    p.style.borderColor="";
    passError.textContent = '';
    pError.textContent = '';
  }

  login();
  loginForm();
  return isValid;

  }
  
  
 
  


  function loginForm(){
    var username = document.getElementById("signinUsername").value;
    var password = document.getElementById("signinPassword").value;
    callLoginFormBackend(username,password);
  }
  function callLoginFormBackend(username,password) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"username":"'+username+'","password":"' +password+'"}';
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackLoginFormBackend( this.responseText);
    }
    
  };
  
  xhttp.open("POST", "http://localhost:8080/LoginForm", true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackLoginFormBackend(res){
    alert(res)
  }