function fileChange(obj){

    var filePath = obj.value;
    var fileSlashIdx = filePath.lastIndexOf("\\");
    var fileFullName = filePath.substring(fileSlashIdx + 1, filePath.length);
    var fileDot = fileFullName.lastIndexOf(".");
    var fileExt = fileFullName.substring(fileDot + 1, fileFullName.length);
    var fileExtLow = fileExt.toLowerCase();

    var uploadForm = document.getElementById('upload-form');
    var fileUploadBtn = document.getElementById('file-upload');
    var confirm = window.confirm("해당 파일로 확정하시겠습니까?");

    console.log("업로드 파일 전체 경로: " + filePath);
    console.log("업로드 파일명: " + fileFullName);
    console.log("업로드 파일 확장자: "+ fileExt);
    console.log("업로드 파일 소문자 확장자: "+ fileExtLow);

    if(confirm){
        if(fileExtLow == "xls" || fileExtLow == "xlsx"){
            document.getElementById('upload-name').value = filePath;
            fileUpload(uploadForm);
        }else{
            document.getElementById('upload-name').value = "";
            alert("업로드 파일의 확장자를 확인해주시기 바랍니다.");
        }
    }

}

function listChange(obj){

    var data = new FormData();

    data.append("file", obj[0]);

    fetch("/excel/excelToFileList", {
        method: "POST",
        headers: {},
        body: data
    }).then(res =>{
        console.log("성공");
    }).catch(error=>{
        console.log("실패");
    })

}

function fileUpload(file){

    var data = new FormData(file);

    fetch("/excel/excelToFileName", {
        method: "POST",
        headers: {},
        body: data
    }).then(res =>{
        console.log("성공");
    }).catch(error=>{
        console.log("실패");
    })

}