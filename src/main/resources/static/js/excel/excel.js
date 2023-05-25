function fileChange(obj){

    var filePath = obj.value;
    var fileSlashIdx = filePath.lastIndexOf("\\");
    var fileFullName = filePath.substring(fileSlashIdx + 1, filePath.length);
    var fileDot = fileFullName.lastIndexOf(".");
    var fileExt = fileFullName.substring(fileDot + 1, fileFullName.length);

    console.log("업로드 파일 전체 경로: " + filePath);
    console.log("업로드 파일명: " + fileFullName);
    console.log("업로드 파일 확장자: "+ fileExt);

    if(fileExt == "xls" || fileExt == "xlsx"){
        document.getElementById('upload-name').value = filePath;
    }else{
        document.getElementById('upload-name').value = "";
        alert("서식 파일의 확장자를 확인해주시기 바랍니다.");
    }

}