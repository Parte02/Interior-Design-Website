function appointment(){
    var name= document.getElementById("name").value;  
    var phone = document.getElementById("phone").value;  
    var email = document.getElementById("email").value;  
    var date = document.getElementById("date").value; 
    var time = document.getElementById("time").value;
    var address =document.getElementById("area").value;
  
    callAppointmentBackend(name,phone,email,date,time,address);
  }
  function callAppointmentBackend(name,phone,email,date,time,address) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"name":"'+name+'","phone":"' +phone+'","email":"' +email+'","date":"' +date+'","time":"' +time+'","address":"' +address+'"}';
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackAppointmentBackend( this.responseText);
    }
  };
  
  xhttp.open("POST", "http://localhost:8080/BookForm", true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  

  function result(){
    alert("Your Appoiment is Successfully ")
  }
  
  function validForm() {
    var n = document.getElementById('name');
    var e = document.getElementById('email');
    var p = document.getElementById('phone');
    var d = document.getElementById('date');
    var t = document.getElementById('time');
    var a =document.getElementById('area');

    var nameError = document.getElementById('nameError');
    var emailError = document.getElementById('emailError');
    var phoneError = document.getElementById('phoneError');
    var dateError = document.getElementById('dateError');
    var timeError = document.getElementById('timeError');
    var areaError = document.getElementById('areaError');
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    var phonePattern = /^\d{10}$/;
    
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
   if (!emailPattern.test(e.value)||e.value === '') {
        e.style.borderColor="red";
        emailError.textContent = 'Invalid email format!';
        isValid = false;
        
    } else {
      e.style.borderColor="";
      emailError.textContent = '';
    }
    

    // Validate Phone
  
    if (!phonePattern.test(p.value)||p.value === '') {
      p.style.borderColor="red";
        phoneError.textContent = 'Phone number must be 10 digits!';
        isValid = false;
        
    } else {
      p.style.borderColor="";
      phoneError.textContent = '';
       
    }
    

    // Validate Date of Birth
    if (d.value === '') {
        d.style.borderColor="red";
        dateError.textContent = 'Date is required!';
        isValid = false;
        
    } else {
        d.style.borderColor="";
        dateError.textContent = '';
    }

    // Validate Time
    if (t.value === '') {
        t.style.borderColor="red";
        timeError.textContent = 'Time is required!';
        isValid = false;
    } else {
        t.style.borderColor="";
        timeError.textContent = '';
    }

    if (a.value === '') {
      a.style.borderColor="red";
      areaError.textContent = 'Address is required!';
      isValid = false;
      return false;
  } else {
      a.style.borderColor="";
      areaError.textContent = '';
  }
    appointment();
    result();
    clean();
    return isValid;
  
  
}
    
function clean(){
   
  document.getElementById("name").value='';
  document.getElementById("email").value='';
  document.getElementById("phone").value='';
  document.getElementById("date").value='';
  document.getElementById("time").value='';
  document.getElementById("area").value='';

  
}