
let element = document.getElementById("submitButton");




element.addEventListener("click", function() {

let username = document.getElementById("username").value
let password = document.getElementById("password").value

    
    var dataToSend = {
        "username": username,
        "password": password
    };

    var jsonData = JSON.stringify(dataToSend);

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET",`/auth/login?username=${username}&password=${password}`,true);
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.setRequestHeader("Authorization", null);
    xhttp.send()

    xhttp.onload = ()=>{
          
        if(xhttp.status === 200){
            
                var responseData = JSON.parse(xhttp.response);
                window.location.href = `/user/home?token=${responseData["jwtToken"]}`;

        }

    }

  

}); 