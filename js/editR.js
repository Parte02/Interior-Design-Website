function edit(){
  var name = document.getElementById("registerUsername").value;
  document.getElementById("registerUsername").value='';
  var email = document.getElementById("registerEmail").value;
  document.getElementById("registerEmail").value='';
  var password = document.getElementById("registerPassword").value;
  document.getElementById("registerPassword").value='';
  var confirm_password = document.getElementById("registerPasswordRetry").value;
  document.getElementById("registerPasswordRetry").value='';

  callEditBackend(name,email,password,confirm_password);
}
function callEditBackend(name,email,password,confirm_password) {
var xhttp = new XMLHttpRequest(); //object
var data='{"name":"'+name+'","email":"'+email+'","password":"'+ password +'","confirm password":"'+confirm_password+'"}';
alert("data: "+data);
xhttp.onreadystatechange = function() { 
  if (this.readyState == 4 && this.status == 200) {
    callbackEditBackend( this.responseText);
  }
};
  const params = new URLSearchParams(window.location.search);
  const id = params.get('id');
  alert("id="+id);
  

xhttp.open("POST", "http://localhost:8080/updateUser/"+id,true);
xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
xhttp.send(data);
}
function callbackEditBackend(res){
  alert(res)
  alert("Update Successfully")
  
}

