function userLogin(){

    var loginForm = document.getElementById('login-form');

    var data = new FormData(loginForm);

    fetch("/usr/login", {
        method: "POST",
        headers: {},
        body: data
    }).then(res =>{
        console.log("성공");
        alert("로그인에 성공했습니다.");
        location.href = "/";
    }).catch(error=>{
        console.log("실패");
    })

}

function userIdCheck(){

    var loginForm = document.getElementById('login-form');

    var data = new FormData(loginForm);

    fetch("/usr/joinIdCheck", {
        method: "POST",
        headers: {},
        body: data
    }).then(res =>{
        console.log(res);
        console.log(userYn);

        if(res == "Yes"){
            alert("해당 아이디는 사용하셔도 괜찮습니다.");
        }else{
            alert("이미 존재하는 아이디입니다.")
        }
        console.log("성공");
    }).catch(error=>{
        console.log(error);
        console.log("실패");
    })

}

function userJoin(){

}