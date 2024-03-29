function edit(){
    var name = document.getElementById("p_name").value;
    document.getElementById("p_name").value='';
    var location = document.getElementById("p_location").value;
    document.getElementById("p_location").value='';
    var s_date = document.getElementById("s_date").value;
    document.getElementById("s_date").value='';
    var e_date = document.getElementById("e_date").value;
    document.getElementById("e_date").value='';

    callEditBackend(name,location,s_date,e_date);
  }
  function callEditBackend(name,location,s_date,e_date) {
  var xhttp = new XMLHttpRequest(); //object
  var data='{"name":"'+name+'","location":"'+location+'","start_date":"'+ s_date +'","end_date":"'+e_date+'"}';
  alert("data: "+data);
  xhttp.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackEditBackend( this.responseText);
    }
  };
    const params = new URLSearchParams(window.location.search);
    const id = params.get('id');
    alert("id="+id);
    
  
  xhttp.open("POST", "http://localhost:8080/updateProject/"+id,true);
  xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhttp.send(data);
  }
  function callbackEditBackend(res){
    alert(res)
    alert("Update Successfully")
    
  }
  
