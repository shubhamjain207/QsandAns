
let element = document.getElementById("submitButton");

let tokenEle = document.getElementById("token");


let username = document.getElementById("username");
let fullname = document.getElementById("fullname");
let image = document.getElementById("image");

let yourQsContainer = document.getElementById("yourQsContainer");

let displayProfile = document.getElementsByClassName("displayProfile")[0];
let displayHome = document.getElementsByClassName("displayHome")[0];



const currentPageUrl = window.location.href;

document.addEventListener('keydown', (e) => {
  if (e.code === 'Escape')
           {
            
            if(commentSectionContainer.style.display == "flex"){
              commentSectionContainer.style.display = "none";
            }

           }
  
});



if (currentPageUrl.includes('user/profile')) {
  displayProfile.classList.add('active-link');
}

else if (currentPageUrl.includes('user/home')) {
  displayHome.classList.add('active-link');
} 



var xhttp1 = new XMLHttpRequest();

xhttp1.open("GET", "/auth/getUserQs", true);
xhttp1.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
xhttp1.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
xhttp1.send();

xhttp1.onload = () => {

  if (xhttp1.status === 200) {
    var responseData = JSON.parse(xhttp1.response);

    responseData.forEach((item) => {


      yourQsContainer.innerHTML += 
      
      `
      
      <div class="qsListItem">

      <div class="qsListItemTimeMilli">
      ${item["question_time_milli"]}
      </div>


      <div class="qsListItemContent">
             ${item["questioncontent"]}
      </div>
      <div class="qsListItemDetails">
      <span class="userTime">${item["questionTime"].toString().substring(0,25)}</span>
      </div>
      <div class="showCommentsContainer">
      <button onclick="myFunction(event)" type="button" id="showCommentsBtn">Comments</button>
      </div>
      
      </div>`;
    
    
    });
  }
};

displayHome.addEventListener("click", function () {
  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "/auth/home", true);
  xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp.send();

  xhttp.onload = () => {
    if (xhttp.status === 200) {
      var responseData = JSON.parse(xhttp.response);
      window.location.href = `/user/home?token=${tokenEle.innerText}`;
    }
  };
});

displayProfile.addEventListener("click", function () {
  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "/auth/profile", true);
  xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp.send();

  xhttp.onload = () => {
    if (xhttp.status === 200) {
      var responseData = JSON.parse(xhttp.response);
      window.location.href = `/user/profile?token=${tokenEle.innerText}`;
    }
  };
});



    var xhttp = new XMLHttpRequest();
    xhttp.open("GET","/auth/profile",true);
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.setRequestHeader("Authorization","Bearer "+tokenEle.innerText);
    xhttp.send()
        

    xhttp.onload = ()=>{
        console.log(xhttp.response);
        
        if(xhttp.status === 200){
            var responseData = JSON.parse(xhttp.response);
            
            username.innerText = responseData["username"];
            fullname.innerText = responseData["fullname"];
            image.innerText = responseData["image"];


        }

    }

  function myFunction(event){
      if(commentSectionContainer.style.display == "flex"){
        commentSectionContainer.style.display = "none";
      }
            
      else{
        commentSectionContainer.style.display = "flex";
      }
    
    
    var qsListItemTimeMilli = event.target.parentElement.parentElement.getElementsByClassName("qsListItemTimeMilli")[0];
    //var userPost = event.target.parentElement.parentElement.getElementsByClassName("userPost")[0];
    
    
    var userPost = "";
    
    
    var xhttp1 = new XMLHttpRequest();
    
    xhttp1.open("GET", `/auth/getAllComments?qsListItemTimeMilli=${qsListItemTimeMilli.innerText.toString().trim()}&userPost=${userPost}`, true);
    xhttp1.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp1.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
    xhttp1.send();
    
    xhttp1.onload = () => {
      if (xhttp1.status === 200) {
        var responseData = JSON.parse(xhttp1.response);
    
        commentSection.innerHTML = "";
    
        responseData.forEach((item) => {
    
         commentSection.innerHTML += 
          
          `
          <div class="commentListItem">
          
    
          <div class="commentListItemContent">
                 ${item["comment_content"]}
          </div>
          
          <div class="commentListItemDetails">
                 <span class="userPost">${item["comment_user"]}</span><br>
                 ${item["comment_time"].toString().substring(0,25)}
          </div>
    
         
          </div>
         
      `;
        
        
        });
      }
    };
    
    
    }
    
   

