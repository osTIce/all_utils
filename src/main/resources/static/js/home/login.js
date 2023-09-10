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