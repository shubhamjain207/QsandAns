let element = document.getElementById("submitButton");

element.addEventListener("click", function() {

    
let username = document.getElementById("username").value
let password = document.getElementById("password").value
// let profileimage = document.getElementById("profileimage").value
let fullname = document.getElementById("fullname").value
    
    var dataToSend = {
        "username": username,
        "password": password,
        "profileimage":"",
        "fullname":fullname
    };


    console.log("Image---------------->",typeof profileimage);


    var jsonData = JSON.stringify(dataToSend);

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","/auth/register");
    xhttp.overrideMimeType("text/html");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.setRequestHeader("Authorization", null);
    xhttp.send(jsonData)
        
  
    xhttp.onload = ()=>{
        
        if(xhttp.status === 200){
            window.location.href = "/user/login";
        }
    }

  

}); 