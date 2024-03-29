var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');


function uploadSingleFile(file) {
    var formData = new FormData();
    formData.append("file", file);

    const params = new URLSearchParams(window.location.search);
    const id = params.get('id');
    alert("id="+id);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/uploadFile/"+id,true);

    
    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = (xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response + "' target='_blank'>" + response + "</a></p>";
            singleFileUploadSuccess.style.display = "block";




        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
    
}


singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";


    }
	alert(files[0])
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);

function imageId(){
        callImageBackend();
    } 
  function callImageBackend() {
    var xhtt = new XMLHttpRequest(); //object
    
    xhtt.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        callbackImageBackend( this.responseText);
      }
    };
    const params = new URLSearchParams(window.location.search);
    const id = params.get('id');
    alert("id="+id);
    xhtt.open("POST", "http://localhost:8080/findImage/"+id ,true);
    xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhtt.send();
    }
    function callbackImageBackend(res){
      alert(res)
      

      
      const result = JSON.parse(res);
      
      var imageBeans=result.imageBeans;  

      if(result.errId==-1){
        for (var i =0; i<imageBeans.length; i++){
            var img=imageBeans[i];
          var imageBody=document.getElementById("output");
          console.log(+img.pkid+","+img.img_name+","+img.fkid);


        var pkid = document.getElementById("pkid");
        pkid.innerHTML="Image ID ="+img.pkid;

       
        var imgName = document.getElementById("imgName");
        imgName.innerHTML=" Image Name ="+img.img_name;


        var fkid = document.getElementById("fkid");
        fkid.innerHTML=" Project ID ="+img.fkid;

       
        
        }
        
      }
      
      else{
        alert("error")
      }
      
      callImage();
      
    }


    




    function callImage() {
      var xhtt = new XMLHttpRequest(); //object
      
      xhtt.onreadystatechange = function() { 
        if (this.readyState == 4 && this.status == 200) {
          callbackImage( this.responseText);
        }
      };
      const params = new URLSearchParams(window.location.search);
      const id = params.get('id');
      alert("id="+id);
  
      xhtt.open("POST", "http://localhost:8080/findImage/"+id ,true);
      xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
      xhtt.send();
      }
      function callbackImage(res){
        
        const result = JSON.parse(res);
        
        var imageBeans=result.imageBeans;  
  
        if(result.errId==-1){
          for (var i =0; i<imageBeans.length; i++){
              var img=imageBeans[i];
        createImage(img);
            }
            
        }
        else{
          alert("error")
        }
      }
      clean();
        
    function createImage(img){
      const demo1=document.getElementById("ShowImg");
     
      var pkid=img.pkid
      var close=document.createElement("icon");{
        close.innerHTML='<i class = "fa fa-close" style="font-size:36px" onclick='+'deleteImage('+pkid+')></i>';
        close.addEventListener('click', deleteImage);
        close.style.marginRight="-290px";
        close.style.marginTop="200%";
       
        }
        var img1=document.createElement("img");
        img1.style.marginRight="200px"
        img1.style.marginTop="30px";
   

    img1.src="http://localhost:8282/id-images/"+img.img_name;
    demo1.appendChild(close);
    demo1.appendChild(img1);
    
    }

    function getAllProjectImages(){
      callImage(); 
    }




    function clean(){

      const demo=document.getElementById("ShowImg");
      while(demo.firstElementChild){
      demo.removeChild(demo.firstElementChild);
     
      }
    }



  




function details(){
      callProjectIdBackend();
  } 
function callProjectIdBackend() {
  var xhtt = new XMLHttpRequest(); //object
  
  xhtt.onreadystatechange = function() { 
    if (this.readyState == 4 && this.status == 200) {
      callbackProjectIdBackend( this.responseText);
    }
  };
  const params = new URLSearchParams(window.location.search);
  const id = params.get('id');
  alert("id="+id);
  xhtt.open("POST", "http://localhost:8080/getProject/"+id ,true);
  xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
  xhtt.send();
  }
  function callbackProjectIdBackend(res){
    alert(res)

    var op= document.getElementById("output");
   
    const result = JSON.parse(res);
    
    var projectBeans=result.projectBeans;  

    if(result.errId==-1){
      for (var i =0; i<projectBeans.length; i++){
          var pro=projectBeans[i];
        console.log(+pro.id+","+pro.name+","+pro.location+","+pro.start_date+","+pro.end_date+","+pro.created_by+","+pro.updated_by);


      var name = document.getElementById("name");
      name.innerHTML="Name ="+pro.name;

     
      var location = document.getElementById("location");
      location.innerHTML=" Location ="+pro.location;


      var start_date = document.getElementById("start_date");
      start_date.innerHTML=" Start Date ="+pro.start_date;

      var end_date = document.getElementById("end_date");
      end_date.innerHTML=" End Date ="+pro.end_date;

      
      }
    }
    else{
      alert("error")
    }
  }
   
  
  function deleteImage(pkid) {
    var xhtt = new XMLHttpRequest(); //object
    alert("pkid="+pkid)
    xhtt.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        deletebackImage( this.responseText);
      }
    };
    

    xhtt.open("POST", "http://localhost:8080/deleteImage/"+pkid ,true);
    xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhtt.send();
    
}
    function deletebackImage(res){
      
      alert(res)
      clean();
      getAllProjectImages();
    }

    