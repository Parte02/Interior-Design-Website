function add(){
    var name = document.getElementById("p_name").value;
    var location = document.getElementById("p_location").value;
    var s_date = document.getElementById("s_date").value;
    var e_date = document.getElementById("e_date").value;

    callInsertProjectBackend(name,location,s_date,e_date);
  }
  function callInsertProjectBackend(name,location,s_date,e_date) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"name":"'+name+'","location":"'+location+'","start_date":"'+ s_date +'","end_date":"'+e_date+'"}';
  alert("data: "+data);
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackInsertProjectBackend( this.responseText);
    }
  };
  var token=localStorage.getItem('auth_token');
  alert("token="+token);
  xhttp.open("POST", "http://localhost:8080/createProject/"+token,true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackInsertProjectBackend(res){
  alert(res)
    
  }
  function clean(){
    document.getElementById("p_name").value='';
    document.getElementById("p_location").value='';
    document.getElementById("s_date").value='';
    document.getElementById("e_date").value='';
  }
  function validForm() {
    var n = document.getElementById('p_name');
    var l = document.getElementById("p_location");
    var s = document.getElementById('s_date');
    var e =document.getElementById('e_date');

    var nameError = document.getElementById('nameError');
    var locationError = document.getElementById('locationError');
    var startError = document.getElementById('startError');
    var endError = document.getElementById('endError');
   
    
    var isValid = true;

    // Validate Name
    if (n.value === ''){
        nameError.textContent = 'Name is required!';
        n.style.borderColor="red";
        isValid = false;
        
       
    } else {
        nameError.textContent = '';
        n.style.borderColor="";
    }

    // Validate Email
    if(l.value === ''){
      l.style.borderColor="red";
      locationError.textContent = 'Location is required!';
      isValid = false;
      
    }
    else {
        locationError.textContent = '';
        l.style.borderColor="";
    }
    

    // Validate Phone
    if(s.value === ''){
      s.style.borderColor="red";
      startError.textContent = 'Start Date is required!';
      isValid = false; 
    }
    else {
        startError.textContent = '';
        s.style.borderColor="";
    }

    if(e.value === ''){
      endError.textContent = 'Start Date is required!';
      e.style.borderColor="red";
      isValid = false;
      return false;
    }
    else {
        endError.textContent = '';
        e.style.borderColor="";
    }

    
    add();
    clean();
    return isValid;
  
  
}