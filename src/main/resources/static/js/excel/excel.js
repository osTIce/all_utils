function fileChange(obj){

    var filePath = obj.value;
    var fileSlashIdx = filePath.lastIndexOf("\\");
    var fileFullName = filePath.substring(fileSlashIdx + 1, filePath.length);
    var fileDot = fileFullName.lastIndexOf(".");
    var fileExt = fileFullName.substring(fileDot + 1, fileFullName.length);
    var fileExtLow = fileExt.toLowerCase();

    var fileUploadBtn = document.getElementById('file-upload');
    var confirm = window.confirm("해당 파일로 확정하시겠습니까?");

    console.log("업로드 파일 전체 경로: " + filePath);
    console.log("업로드 파일명: " + fileFullName);
    console.log("업로드 파일 확장자: "+ fileExt);
    console.log("업로드 파일 소문자 확장자: "+ fileExtLow);

    if(confirm){
        if(fileExtLow == "xls" || fileExtLow == "xlsx"){
            document.getElementById('upload-name').value = filePath;
            fileUpload(filePath);
        }else{
            document.getElementById('upload-name').value = "";
            alert("업로드 파일의 확장자를 확인해주시기 바랍니다.");
        }
    }

}

function fileUpload(file){

    var xhr = new XMLHttpRequest();
    var method = "POST";
    var url = "/excel/excelToFileName";

    xhr.open(method, url, true);
    xhr.send(file);


}