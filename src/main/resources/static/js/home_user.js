let displayHome = document.getElementById("displayHome");
let displayProfile = document.getElementById("displayProfile");

let qsList = document.getElementById("QsList");

let commentSectionContainer = document.getElementById(
  "commentSectionContainer"
);

let postQsBtn = document.getElementById("postQs1");
let displayInputForQs = document.getElementById("displayInputForQs");
let inputForQs = document.getElementById("inputForQs");
let closeBtn = document.getElementById("closeBtn");

let tokenEle = document.getElementById("token");

closeBtn.addEventListener("click", () => {
  if ((inputForQs.style.display = "flex")) {
    inputForQs.style.display = "none";
  }

  if ((displayInputForQs.style.display = "none")) {
    displayInputForQs.style.display = "block";
  }
});

document.addEventListener("keydown", (e) => {
  if (e.code === "Escape") {
    if (commentSectionContainer.style.display == "flex") {
      commentSectionContainer.style.display = "none";
      document.body.style.overflowY = "scroll";
    }

    if ((inputForQs.style.display = "flex")) {
      inputForQs.style.display = "none";
    }

    if ((displayInputForQs.style.display = "none")) {
      displayInputForQs.style.display = "block";
    }
  }
});

const currentPageUrl = window.location.href;

if (currentPageUrl.includes("user/profile")) {
  displayProfile.classList.add("active-link");
} else if (currentPageUrl.includes("user/home")) {
  displayHome.classList.add("active-link");
}

displayInputForQs.addEventListener("click", function () {
  if (inputForQs.style.display == "flex") {
    inputForQs.style.display = "none";
  } else {
    inputForQs.style.display = "flex";
    displayInputForQs.style.display = "none";
  }
});

var xhttp1 = new XMLHttpRequest();

xhttp1.open("GET", "/auth/getAllQs", true);
xhttp1.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
xhttp1.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
xhttp1.send();

xhttp1.onload = () => {
  if (xhttp1.status === 200) {
    var responseData = JSON.parse(xhttp1.response);

    responseData.forEach((item) => {
      qsList.innerHTML += `
      <div class="qsListItem">
      <div class="qsListItemTimeMilli">
      ${item["question_time_milli"]}
      </div>

      <div class="qsListItemContent">
             ${item["questioncontent"]}
      </div>
      <div class="qsListItemDetails">
             <span class="userPost">${item["questionUser"]}</span><br>
             <span class="userTime">${item["questionTime"]
               .toString()
               .substring(0, 25)}</span>
      </div>

      <div class="qsListCommentBox">
            <textarea class ="commentBox" name="commentBox" rows="10" cols="100" maxlength="400"></textarea>
            <button onclick="postComment()" type="button" class="postCommentBtn">Post Comment</button>
      </div>

      
      <div class="likeBtnBox">
            <span id = "${item["id"]}" class="likeCountNumber">${
        item["likeCount"]
      }</span>&nbsp;&nbsp;
            <button onclick="likePost(${
              item["id"]
            })" type="button" class="likePostBtn">Like</button>
      </div>

      
      <div class="showCommentsContainer">
      <button onclick="myFunction(event)" type="button" class="showCommentsBtn">Comments</button>
      </div>
     
      </div>
     
  `;
    });
  }
};

function likePost(id) {
  console.log(id);

  if (likedQuestions.includes(id)) {
    console.log("Question already liked");
    return; // Exit the function if already liked
  }
  
  let likeCountContainer = document.querySelector(`span[id="${id}"]`);

  let currentLikeCount = parseInt(likeCountContainer.innerText);
  let newLikeCount = currentLikeCount + 1;

  let likeCountConv = newLikeCount.toString();

  var data = {
    likeCount: likeCountConv,
  };

  var jsonData = JSON.stringify(data);

  var xhttp = new XMLHttpRequest();
  xhttp.open("PUT", "/auth/questions/" + id + "/like", true);
  xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp.send(jsonData);

  xhttp.onload = () => {
    if (xhttp.status === 200) {
      likeCountContainer.innerText = likeCountConv;

      likedQuestions += "," + id;
      console.log("Liked data --->" + likedQuestions);

      var dataQuestion = {
        likedQuestion: likedQuestions,
      };

      var quesntionLikedData = JSON.stringify(dataQuestion);

      var xhttp_ = new XMLHttpRequest();
      xhttp_.open("PUT", "/auth/question/" + id, true);
      xhttp_.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      xhttp_.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
      xhttp_.send(quesntionLikedData);

      xhttp_.onload = () => {
        if (xhttp_.status === 200) {
          console.log("Addition sucess");
        }
      };
    }
  };
}

function postComment() {
  let commentInput = this.document.getElementsByClassName("commentBox")[0];

  if (commentInput.value == "") {
    return;
  }

  var date = new Date();

  let timeInMilliHidden = this.document.getElementsByClassName(
    "qsListItemTimeMilli"
  )[0];
  let userPost = this.document.getElementsByClassName("userPost")[0];

  var data = {
    content: commentInput.value,
    content_user: userPost.innerText.toString().trim(),
    time: date.toString(),
    timemilli: timeInMilliHidden.innerText.toString().trim(),
  };

  var jsonData = JSON.stringify(data);

  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "/auth/setComment", true);
  xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp.send(jsonData);

  xhttp.onload = () => {
    if (xhttp.status === 200) {
      var responseData = JSON.parse(xhttp.response);
      // window.location.href = `/user/profile?token=${tokenEle.innerText}`;
      window.location.href = `/user/home?token=${tokenEle.innerText}`;
    }
  };
}

function myFunction(event) {
  if (commentSectionContainer.style.display == "flex") {
    commentSectionContainer.style.display = "none";
  } else {
    commentSectionContainer.style.display = "flex";
    document.body.style.overflowY = "hidden";
  }

  var qsListItemTimeMilli =
    event.target.parentElement.parentElement.getElementsByClassName(
      "qsListItemTimeMilli"
    )[0];
  var userPost =
    event.target.parentElement.parentElement.getElementsByClassName(
      "userPost"
    )[0];

  var xhttp1 = new XMLHttpRequest();

  xhttp1.open(
    "GET",
    `/auth/getAllComments?qsListItemTimeMilli=${qsListItemTimeMilli.innerText
      .toString()
      .trim()}&userPost=${userPost.innerText.toString().trim()}`,
    true
  );
  xhttp1.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp1.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp1.send();

  xhttp1.onload = () => {
    if (xhttp1.status === 200) {
      var responseData = JSON.parse(xhttp1.response);

      commentSection.innerHTML = "";

      responseData.forEach((item) => {
        commentSection.innerHTML += `
      <div class="commentListItem">
      

      <div class="commentListItemContent">
             ${item["comment_content"]}
      </div>
      
      <div class="commentListItemDetails">
             <span class="userPost">${item["comment_user"]}</span><br>
             ${item["comment_time"].toString().substring(0, 25)}
      </div>

     
      </div>
     
  `;
      });
    }
  };
}

// })

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

postQsBtn.addEventListener("click", function () {
  let qsInput = document.getElementById("qsInput");

  if (qsInput.value == "") {
    return;
  }

  var date = new Date();
  var date1 = Date.now();

  var data = {
    content: qsInput.value,
    time: date.toString(),
    timemilli: date1.toString(),
    likecount: "0",
  };

  var jsonData = JSON.stringify(data);

  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "/auth/setQs", true);
  xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhttp.setRequestHeader("Authorization", "Bearer " + tokenEle.innerText);
  xhttp.send(jsonData);

  xhttp.onload = () => {
    if (xhttp.status === 200) {
      var responseData = JSON.parse(xhttp.response);
      // window.location.href = `/user/profile?token=${tokenEle.innerText}`;
      window.location.href = `/user/home?token=${tokenEle.innerText}`;
    }
  };
});
