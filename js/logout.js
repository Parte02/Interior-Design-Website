function logout(){
    callLogoutBackend();
}
function callLogoutBackend() {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        callbackLogoutBackend( this.responseText);
      }
    };
    var tokenTORemove=localStorage.getItem('auth_token');
    alert("tokenTORemove="+tokenTORemove);
    xhttp.open("POST", "http://localhost:8080/Logout/"+tokenTORemove, true);
    xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhttp.send();
    }
    function callbackLogoutBackend(res){
        alert(res)
        const result = JSON.parse(res);
        if(result.errId==-1){
        localStorage.removeItem('auth_token');
        alert("Successfully Logout")
        window.location.href ='index.html';
        }
        else{
          alert("Unable to Logout")
        }
    }