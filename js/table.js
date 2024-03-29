
function show(){
    callProjectBackend();
} 
function callProjectBackend() {
    var xhttp = new XMLHttpRequest(); //object
    
    xhttp.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        callbackProjectBackend( this.responseText);
      }
    };
    var token=localStorage.getItem('auth_token');
    alert("token="+token);
    xhttp.open("POST", "http://localhost:8080/getAllProjectDetails/"+token ,true);
    xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhttp.send();
    }
    function callbackProjectBackend(res){
      
        const result = JSON.parse(res);
        
      var projectBeans=result.projectBeans;
    
      if(result.errId==-1){
      for (var i =0; i<projectBeans.length; i++){
        var pro=projectBeans[i];
      var projectTableBody=document.getElementById("projectTableBody");
      console.log(+pro.id+","+pro.name+","+pro.location+","+pro.start_date+","+pro.end_date+","+pro.created_by+","+pro.updated_by);
      

      var projectTr=document.createElement("tr");
      projectTableBody.appendChild(projectTr);

      var idTd=document.createElement("td");
      idTd.innerHTML=""+pro.id;

      var nameTd=document.createElement("td");
      nameTd.innerHTML=""+pro.name;

      var locationTd=document.createElement("td");
      locationTd.innerHTML=""+pro.location;

      var s_dateTd=document.createElement("td");
      s_dateTd.innerHTML=""+pro.start_date;

      var e_dateTd=document.createElement("td");
      e_dateTd.innerHTML=""+pro.end_date;

      var imageTd=document.createElement("td");
      imageTd.innerHTML='<a href="image.html?id='+pro.id+'">Add</a>';

      var editTd=document.createElement("td");
      editTd.innerHTML=' <a href="editPro.html?id='+pro.id+'"><i class = "fa fa-edit" onclick='+'data('+pro.id+')></i></a>';
     

      var deleteTd=document.createElement("td");
      var deleteIcon = document.createElement("i");
      deleteIcon.className = "fa fa-trash";
      deleteIcon.dataset.id = pro.id; 
      deleteIcon.addEventListener('click', callDelete); // Attach click event handler
      deleteTd.appendChild(deleteIcon);


      projectTr.appendChild(idTd);
      projectTr.appendChild(nameTd);
      projectTr.appendChild(locationTd);
      projectTr.appendChild(s_dateTd);
      projectTr.appendChild(e_dateTd);
      projectTr.appendChild(imageTd);
      projectTr.appendChild(editTd);
      projectTr.appendChild(deleteTd);
     
      }
    document.body.appendChild(table);

    function callDelete() {
      var projectId = this.dataset.id;
      var xhttp = new XMLHttpRequest(); //object
      xhttp.onreadystatechange = function() { 
        if (this.readyState == 4 && this.status == 200) {
          callbackDelete( this.responseText,projectId);
        }
      };    
      
      var id = projectId; // Use the project ID
      alert("id=" + id);
     
      xhttp.open("POST", "http://localhost:8080/deleteProject/"+id, true);
      xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
      xhttp.send();
      }
      function callbackDelete(result){
        alert(result)  
        alert("Succesfully Delted")
        clean();
        getAllData();

        
      }

    data(pro);
 
      } 
     
      
      else{
        alert("error")
      }
      
    }
    
    

function data(){
    
      callDataBackend();
  } 
  function callDataBackend() {
      var xhttp = new XMLHttpRequest(); //object
      
      xhttp.onreadystatechange = function() { 
        if (this.readyState == 4 && this.status == 200) {
          callbackDataBackend( this.responseText);
        }
      };
      const params = new URLSearchParams(window.location.search);
    const id = params.get('id');
    alert("id="+id);

      xhttp.open("POST", "http://localhost:8080/getProject/"+id ,true);
      xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
      xhttp.send();
      }
      function callbackDataBackend(res){
        
        
          const result = JSON.parse(res);
          
        var projectBeans=result.projectBeans;
      
        if(result.errId==-1){
        for (var i =0; i<projectBeans.length; i++){
          var pro=projectBeans[i];
          console.log(+pro.id+","+pro.name+","+pro.location+","+pro.start_date+","+pro.end_date);

        var name = document.getElementById("p_name");
        name.value=""+pro.name;
     

        var location = document.getElementById("p_location");
        location.value=""+pro.location;
        

        var start_date = document.getElementById("s_date");
        start_date.value=""+pro.start_date;

        var end_date = document.getElementById("e_date");
        end_date.value=""+pro.end_date;

        }
      }
      else{
        alert("error")
      }
   }

   function getAllData(){
    show(); 
  }
  function clean(){

    const demo=document.getElementById("projectTableBody");
    while(demo.firstElementChild){
    demo.removeChild(demo.firstElementChild);
  
    }
  }