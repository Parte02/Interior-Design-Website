function contact(){
    var name= document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var message = document.getElementById("message").value;
  

    callContactBackend(name,email,phone,message);
  }
  function callContactBackend(name,email,phone,message) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"name":"'+name+'","email":"' +email+'","phone":"' +phone+'","message":"' +message+'"}';
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackContactBackend( this.responseText);
      
    }
  };
  
  xhttp.open("POST", "http://localhost:8080/ContactForm", true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackContactBackend(res){
    alert(res)
  }

  function clean(){
    document.getElementById("name").value='';
    document.getElementById("email").value='';
    document.getElementById("phone").value='';
    document.getElementById("message").value='';
  }
  function validForm() {
    var n = document.getElementById('name');
    var e = document.getElementById('email');
    var p = document.getElementById('phone');
    var m =document.getElementById('message');

    var nameError = document.getElementById('nameError');
    var emailError = document.getElementById('emailError');
    var phoneNo = document.getElementById('phoneNo');
    var phoneError = document.getElementById('phoneError');
    var messageError = document.getElementById('messageError');
    var emailC = document .getElementById('emailC');
    
    var isValid = true;

    // Validate Name
    if (n.value === ''){
        n.style.borderColor="red";
        nameError.textContent = 'Name is required!';
        isValid = false;
   
    } else {
      n.style.borderColor="";
        nameError.textContent = '';
    }

    // Validate Email
    if(e.value === ''){
      e.style.borderColor="red";
      emailC.textContent = 'Email is required!';
      isValid = false;
      
    }
    else if (!/^\S+@\S+\.\S+$/.test(e.value)) {
        emailError.textContent = 'Invalid email format!';
        isValid = false;
        
    } else {
        e.style.borderColor='';
        emailError.textContent = '';
        emailC.textContent = '' ;
    }
    

    // Validate Phone
    if(p.value === ''){
      p.style.borderColor="red";
      phoneNo.textContent = 'Phone Number is required!';
      isValid = false;
      
    }
    
    else if (!/^\d{10}$/.test(p.value)) {
        phoneError.textContent = 'Phone number must be 10 digits!';
        isValid = false;
        
    } else {
        phoneError.textContent = '';
        phoneNo.textContent = '';
    }

    if (m.value === '') {
      m.style.borderColor="red";
      messageError.textContent = 'Any Message is required!';
      isValid = false;
      return false;
  } else {
      messageError.textContent = '';
  }
    contact();
    clean();
    return isValid;
  
  
}
    