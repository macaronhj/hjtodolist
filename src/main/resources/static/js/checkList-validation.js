/**
 * 입력 항목 validation
 * @returns {boolean}
 */
function invalid(){
    let check = true;
    let toDoValid = true;

    //한글을 포함한 영문과 특수문자 띄어쓰기 가능
    const regToDo = /[^?a-zA-Z0-9/]/;

    //'할 일' 형식 확인
    if (regToDo.test($("#todo").val()) == false) {
        console.log(1);
        $("#todo").addClass('is-invalid');
        $("#todo").removeClass('is-valid');
        $(".vaild-check").text("한글포함 특수문자와 공백을 입력해주세요.");

        toDoValid = false;
    }
    //'할 일' 값 null 확인
    if ($("#todo").val() == '') {
        console.log(2);
        $("#todo").addClass('is-invalid');
        $("#todo").removeClass('is-valid');
        $(".vaild-check").text("입력 바랍니다.");
        toDoValid = false;
    }
    //할 일 유효성 통과시 유효성 success 처리
    if (toDoValid) {
        console.log(5);
        $("#todo").removeClass('is-invalid');
        $("#todo").addClass('is-valid');
    }

    //할 일 유효성 실패 시 false 리턴
    if (!toDoValid) check = false;
    return check;
}