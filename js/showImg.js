
function callImage() {
    var xhtt = new XMLHttpRequest(); //object
    
    xhtt.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        callbackImage( this.responseText);
      }
    };
    
    const params = new URLSearchParams(window.location.search);
    const imgId = params.get('imgId');
    alert("imgId="+imgId);


    xhtt.open("POST", "http://localhost:8080/displayImage/"+imgId ,true);
    xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhtt.send();
    }
    function callbackImage(res){
      
      const result = JSON.parse(res);
      
      var projectImageBeans=result.projectImageBeans;  

      if(result.errId==-1){
        for (var i =0; i<projectImageBeans.length; i++){
            var img=projectImageBeans[i];
            createImage(img);
       
          }   
      }
      else{
        alert("error")
      }
    }

  function createImage(img){

  const demo1=document.getElementById("ShowImg");
  var img1=document.createElement("img");

  var name = document.getElementById("name");
  name.innerHTML=""+img.name;
  
    img1.src="http://localhost:8282/id-images/"+img.img_name;
  demo1.appendChild(img1);
  
  
  }
  

  

