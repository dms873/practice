//반복문
//for(let i = 0; i < 10; i++) {
  //반복할 코드 }

//1. 초기값 설정(let i = 0;) 
//2. 조건(flase가 되면 멈춤)(i < 10;) 
//3. 코드 실행 후 작업(i++)

// 1부터 10까지 로그
for(let i = 0; i <10 ; i++) {
    console.log(i)
  }
  
  //while
  //let i = 0;
  //while (i < 10) {
  //코드
  //i++; }
  
  // ex
  
  let i = 0;
  
  while(i < 10) {
    console.log(i);
    i++;
  }
  
  //do..while (조건문 아래로 옮길 수 있음)
  
  //let i = 0;
  //do { 
  //코드
  //i++; } while (i < 10)
  
  //break : 멈추고 빠져나옴
  //continue : 멈추고 다음 반복으로 진행
  
  //break
  while(true) //무한반복 
  { let answer = confirm('계속 할까요?');
    if(!answer) {
      break;
    }
  }
  
  //continue
  //짝수만
  
  for(let i = 0; i < 10; i++) {
    if(i%2) {
      continue;
    }
    console.log(i)
  }

  //switch (if else와 비슷)

switch(평가){
    case A :
      // A 일때 코드
    case B :
      // B 일때 코드
    ...
  }
    
  //if문으로 바꾸었을 때
    
    if(평가 == A) {
      // A 일때 코드
    } else if(평가 == B) {
      // B 일때 코드
    }