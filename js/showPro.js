
function callImage() {
    var xhtt = new XMLHttpRequest(); //object
    
    xhtt.onreadystatechange = function() { 
      if (this.readyState == 4 && this.status == 200) {
        callbackImage( this.responseText);
      }
    };
    
    xhtt.open("POST", "http://localhost:8080/showImage" ,true);
    xhtt.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhtt.send();
    }
    function callbackImage(res){
      
      const result = JSON.parse(res);
      
      var projectImageBeans=result.projectImageBeans;  

      if(result.errId==-1){
        for (var i =0; i<projectImageBeans.length; i++){
            var img=projectImageBeans[i];
            console.log(+img.id+","+img.img_name)
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
  img1.style.marginLeft="160px";
  var name=document.createElement("button");
  name.innerHTML='<a href="showImg.html?imgId='+img.id+'">'+img.name+'</a>';
  name.style.marginLeft="-190px";
  name.style.fontSize="20px";
  name.style.padding="5 5 5 5";
  name.style.borderColor="black";
  name.style.backgroundColor="#6a64f1"
  
    img1.src="http://localhost:8282/id-images/"+img.img_name;
  demo1.appendChild(img1);

  demo1.appendChild(name);
  
  }


  

