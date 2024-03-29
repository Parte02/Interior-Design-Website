function register(){
    var username= document.getElementById("registerUsername").value;
    var email = document.getElementById("registerEmail").value;
    var password = document.getElementById("registerPassword").value;
    var confirm_password = document.getElementById("registerPasswordRetry").value;
    callRegisterBackend(username,email,password,confirm_password);
  }
  function callRegisterBackend(username,email,password,confirm_password) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"username":"'+username+'","email":"' +email+'","password":"' +password+'","confirm_password":"' +confirm_password+'"}';
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackRegisterBackend( this.responseText);
    }
  };
  
  xhttp.open("POST", "http://localhost:8080/RegisterForm", true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackRegisterBackend(res){
    alert(res)
    window.location.href ='login.html';

  }
  

  function validForm(){
    var u = document.getElementById('registerUsername');
    var e = document.getElementById('registerEmail');
    var p = document.getElementById('registerPassword');
    var c = document.getElementById('registerPasswordRetry');

    var userError = document.getElementById('userError');
    var passError = document.getElementById('passError');
    var confError = document.getElementById('confError');
    var uError = document.getElementById('uError');
    var eError = document.getElementById('eError');
    var cError = document.getElementById('cError');
    var pError = document.getElementById('pError');

    var isValid = true;

    if(u.value ===''){
        u.style.borderColor="red";
        userError.textContent = 'UserName is required!';
        isValid = false;
    }else{
      u.style.borderColor='';
      userError.textContent='';
    }
    if(!/.{6,20}/.test(u)){
      uError.textContent = 'Username must be [6,20] ';
      isValid = false;
    }else{
      uError.textContent = '';
    }


   
    if(!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.value)){
    e.style.borderColor="red";
    eError.textContent = 'Invalid Email';
    isValid = false;
    }else{
    e.style.borderColor="";
    eError.textContent = '';
    }


    if(p.value ===''){
      p.style.borderColor="red";
      passError.textContent = 'PassWord is required!';
      isValid = false;
    }
    if(!/.{6,}/.test(p.value)){
    pError.textContent = 'Password must be more than 6 symbols';
    isValid = false;
    }else{
      p.style.borderColor="";
      passError.textContent = '';
    pError.textContent = '';
    }

    if(c.value===''){
      c.style.borderColor="red";
      confError.textContent = 'Confirm PassWord is required!';
      isValid = false;
    }
      if(p.value != c.value){
        c.style.borderColor="red";
        cError.textContent = 'Unmatch Password';
        isValid = false;
        return false;
    }
    
    else{
    c.style.borderColor="";
    confError.textContent='';
    cError.textContent = '';
    }
  
  register();
  return isValid;

  }
  