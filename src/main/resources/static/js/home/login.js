function userLogin(){

    var loginForm = document.getElementById('login-form');

    var data = new FormData(loginForm);

    fetch("/usr/login", {
        method: "POST",
        headers: {},
        body: data
    }).then(res =>{
        console.log("성공");
    }).catch(error=>{
        console.log("실패");
    })

}