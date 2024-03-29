
function showUser(){
      callProjectBackend();
  } 
  function callProjectBackend() {
      var xhttp = new XMLHttpRequest(); //object
      
      xhttp.onreadystatechange = function() { 
        if (this.readyState == 4 && this.status == 200) {
          callbackProjectBackend( this.responseText);
        }
      };
      
      xhttp.open("POST", "http://localhost:8080/getUser",true);
      xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
      xhttp.send();
      }
      function callbackProjectBackend(res){
        
          const result = JSON.parse(res);
          
        var registerBeans=result.registerBeans;
      
        if(result.errId==-1){
        for (var i =0; i<registerBeans.length; i++){
          var pro=registerBeans[i];
        var projectTableBody=document.getElementById("projectTableBody");
        console.log(+pro.id+","+pro.username+","+pro.email+","+pro.password+"'"+pro.confirm_password);
          
    
        
  
        var projectTr=document.createElement("tr");
        projectTableBody.appendChild(projectTr);
  
        var idTd=document.createElement("td");
        idTd.innerHTML=""+pro.id;
  
        var nameTd=document.createElement("td");
        nameTd.innerHTML=""+pro.username;
  
        var emailTd=document.createElement("td");
        emailTd.innerHTML=""+pro.email;
  
        var passwordTd=document.createElement("td");
        passwordTd.innerHTML=""+pro.password;
  
        var confirm_passTd=document.createElement("td");
        confirm_passTd.innerHTML=""+pro.confirm_password;
  
          
        var editTd=document.createElement("td");
        editTd.innerHTML=' <a href="editR.html?id='+pro.id+'"><i class = "fa fa-edit" onclick='+'data('+pro.id+')></i></a>';
       
  
        var deleteTd=document.createElement("td");
        var deleteIcon = document.createElement("i");
        deleteIcon.className = "fa fa-trash";
        deleteIcon.dataset.id = pro.id; 
        deleteIcon.addEventListener('click', callDelete); // Attach click event handler
        deleteTd.appendChild(deleteIcon);
  
        projectTr.appendChild(idTd);
        projectTr.appendChild(nameTd);
        projectTr.appendChild(emailTd);
        projectTr.appendChild(passwordTd);
        projectTr.appendChild(confirm_passTd);
        projectTr.appendChild(editTd);
        projectTr.appendChild(deleteTd);
       
        }
     
      function callDelete() {
        var projectId = this.dataset.id;
        var xhttp = new XMLHttpRequest(); //object
        xhttp.onreadystatechange = function() { 
          if (this.readyState == 4 && this.status == 200) {
            callbackDelete( this.responseText,projectId);
          }
        };    
        
         var id = projectId;
         alert("id="+id)
       
        xhttp.open("POST", "http://localhost:8080/deleteUser/"+id, true);
        xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
        xhttp.send();
        }
        function callbackDelete(result){
          alert(result)  
          alert("Delete Successfull")
          clean();
          getAllUser();
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
  
        xhttp.open("POST", "http://localhost:8080/getUser/"+id ,true);
        xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
        xhttp.send();
        }
        function callbackDataBackend(res){
          
          const result = JSON.parse(res);
        
          var registerBeans=result.registerBeans;
        
          if(result.errId==-1){
          for (var i =0; i<registerBeans.length; i++){
            var pro=registerBeans[i];
            console.log(+pro.id+","+pro.username+","+pro.email+","+pro.password+","+pro.confirm_password);
    
          var username = document.getElementById("registerUsername");
          username.value=""+pro.username;
       
    
          var email = document.getElementById("registerEmail");
          email.value=""+pro.email;
          
    
          var password = document.getElementById("registerPassword");
          password.value=""+pro.password;
    
          var confirm_password = document.getElementById("registerPasswordRetry");
          confirm_password.value=""+pro.confirm_password;
  
          }
        }
        else{
          alert("error")
        }
     }
     

     /*-----------Contact Display---------------------------------------------------------------------------*/
     function showContact(){
      callContactBackend();
  } 
  function callContactBackend() {
      var xhttp = new XMLHttpRequest(); //object
      
      xhttp.onreadystatechange = function() { 
        if (this.readyState == 4 && this.status == 200) {
          callbackContactBackend( this.responseText);
        }
      };
      
      xhttp.open("POST", "http://localhost:8080/getContact",true);
      xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
      xhttp.send();
      }
      function callbackContactBackend(res){
        
          const result = JSON.parse(res);
          
        var contactBeans=result.contactBeans;
      
        if(result.errId==-1){
        for (var i =0; i<contactBeans.length; i++){
          var cont=contactBeans[i];
        var projectTableBody=document.getElementById("projectTableBody");
        console.log(+cont.id+","+cont.name+","+cont.email+","+cont.phone+"'"+cont.message);
          
    
        
  
        var projectTr=document.createElement("tr");
        projectTableBody.appendChild(projectTr);
  
        var idTd=document.createElement("td");
        idTd.innerHTML=""+cont.id;

        var phoneTd=document.createElement("td");
        phoneTd.innerHTML=""+cont.phone;
  
        var nameTd=document.createElement("td");
        nameTd.innerHTML=""+cont.name;
  
        var emailTd=document.createElement("td");
        emailTd.innerHTML=""+cont.email;
  
        var messageTd=document.createElement("td");
        messageTd.innerHTML=""+cont.message;
  
        var deleteTd=document.createElement("td");
        var deleteIcon = document.createElement("i");
        deleteIcon.className = "fa fa-trash";
        deleteIcon.dataset.id = cont.id; 
        deleteIcon.addEventListener('click', callContactDelete); // Attach click event handler
        deleteTd.appendChild(deleteIcon);
  
  
        projectTr.appendChild(idTd);
        projectTr.appendChild(nameTd);
        projectTr.appendChild(phoneTd);
        projectTr.appendChild(emailTd);
        projectTr.appendChild(messageTd);
        projectTr.appendChild(deleteTd);
       
        }
      document.body.appendChild(table);
  
      function callContactDelete() {
        var projectId = this.dataset.id;
        var xhttp = new XMLHttpRequest(); //object
        xhttp.onreadystatechange = function() { 
          if (this.readyState == 4 && this.status == 200) {
            callbackDelete( this.responseText,projectId);
          }
        };    
        
         var id = projectId;
         alert("id="+id)
       
        xhttp.open("POST", "http://localhost:8080/deleteContact/"+id, true);
        xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
        xhttp.send();
        }
        function callbackDelete(result){
          alert(result)  
          alert("Succesfully Delted");
          clean();
          getAllContact();

        }
   
        } 
      }

      /*-------------------------------------Book -------------------------------------------*/
      function showBook(){
        callBookBackend();
    } 
    function callBookBackend() {
        var xhttp = new XMLHttpRequest(); //object
        
        xhttp.onreadystatechange = function() { 
          if (this.readyState == 4 && this.status == 200) {
            callbackBookBackend( this.responseText);
          }
        };
        
        xhttp.open("POST", "http://localhost:8080/getBook",true);
        xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
        xhttp.send();
        }
        function callbackBookBackend(res){
          
            const result = JSON.parse(res);
            
          var bookBeans=result.bookBeans;
        
          if(result.errId==-1){
          for (var i =0; i<bookBeans.length; i++){
            var book=bookBeans[i];
          var projectTableBody=document.getElementById("projectTableBody");
          console.log(+book.id+","+book.name+","+book.email+","+book.phone+","+book.date+","+book.time+","+book.address);
            
      
          
    
          var projectTr=document.createElement("tr");
          projectTableBody.appendChild(projectTr);
    
          var idTd=document.createElement("td");
          idTd.innerHTML=""+book.id;
    
          var nameTd=document.createElement("td");
          nameTd.innerHTML=""+book.name;
          
          var phoneTd=document.createElement("td");
          phoneTd.innerHTML=""+book.phone;

          var emailTd=document.createElement("td");
          emailTd.innerHTML=""+book.email;
    
          var dateTd=document.createElement("td");
          dateTd.innerHTML=""+book.date;

          var timeTd=document.createElement("td");
          timeTd.innerHTML=""+book.time;

          var addressTd=document.createElement("td");
          addressTd.innerHTML=""+book.address;
    
          var deleteTd=document.createElement("td");
          var deleteIcon = document.createElement("i");
          deleteIcon.className = "fa fa-trash";
          deleteIcon.dataset.id = book.id; 
          deleteIcon.addEventListener('click', callBookDelete); // Attach click event handler
          deleteTd.appendChild(deleteIcon);
    
    
          projectTr.appendChild(idTd);
          projectTr.appendChild(nameTd);
          projectTr.appendChild(phoneTd);
          projectTr.appendChild(emailTd);
          projectTr.appendChild(dateTd);
          projectTr.appendChild(timeTd);
          projectTr.appendChild(addressTd);
          projectTr.appendChild(deleteTd);
         
          }
       
        function callBookDelete() {
          var bookId = this.dataset.id;
          var xhttp = new XMLHttpRequest(); //object
          xhttp.onreadystatechange = function() { 
            if (this.readyState == 4 && this.status == 200) {
              callbackDelete( this.responseText,bookId);
            }
          };    
          
           var id = bookId;
           alert("id="+id)
         
          xhttp.open("POST", "http://localhost:8080/deleteBook/"+id, true);
          xhttp.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
          xhttp.send();
          }
          function callbackDelete(result){
            alert(result)  
            alert("Succesfully Delted")
            clean();
            getAllBook();
          }
          
          
          } 
          
         
        }
        function getAllBook(){
          showBook(); 
        }
        function getAllContact(){
          showContact(); 
        }
        function getAllUser(){
          showUser(); 
        }
        function clean(){

          const demo=document.getElementById("projectTableBody");
          while(demo.firstElementChild){
          demo.removeChild(demo.firstElementChild);
        
          }
        }