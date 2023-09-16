/* 아이디 중복 여부 확인 변수 No는 중복, Yes 중복 아님 */
var idCheck = "No";

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
    });

}

function userIdCheck(){

    var inputId = document.getElementById('user-id').value;

    if(inputId == "" || inputId == null){
        alert("아이디를 입력해주시기 바랍니다.");
        return;
    }

    var loginForm = document.getElementById('join-form');

    var data = new FormData(loginForm);

    fetch("/usr/joinIdCheck", {
        method: "POST",
        headers: {},
        body: data
    }).then(res => res.text())
      .then(value =>{

        if(value == "Yes"){
            alert("해당 아이디는 사용하셔도 괜찮습니다.");
            idCheck = "Yes";
        }else{
            alert("이미 존재하는 아이디입니다.")
            idCheck = "No";
        }
        console.log("성공");
    }).catch(error=>{
        console.log("실패");
    });

}

function userJoin(){

    var inputId = document.getElementById('user-id').value;
    var inputPw = document.getElementById('user-pw').value;
    var inputRePw = document.getElementById('user-re-pw').value;

    if(inputId == "" || inputId == null){
        alert("아이디를 입력해주시기 바랍니다.");
        return;
    }
    if(inputPw == "" || inputPw == null){
        alert("비밀번호를 입력해주시기 바랍니다.");
        return;
    }
    if(inputRePw == "" || inputRePw == null){
        alert("비밀번호 확인을 입력해주시기 바랍니다.");
        return;
    }
    if(inputPw != inputRePw){
        alert("비밀번호와 비밀번호 확인의 값이 동일하지 확인 바랍니다.");
        return;
    }

    if(idCheck == "Yes"){

        var loginForm = document.getElementById('join-form');

        var data = new FormData(loginForm);

        fetch("/usr/join", {
            method: "POST",
            headers: {},
            body: data
        }).then(res =>{
            console.log("성공");
            alert("회원가입에 성공하셨습니다.\n로그인하시면 됩니다.");
            location.href = "/";
        }).catch(error=>{
            console.log("실패");
        });

    }else{
        alert("아이디 중복여부를 확인해주시기 바랍니다.");
    }
}