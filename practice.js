//arrow function

console.log("1번");
// showError();


// let showError = function(){
//   console.log('error');
// }
console.log("-----1번 안됨----");

console.log("2번");
function showError1() {
  console.log("error");
}


showError1();
console.log("---------");

console.log("3번");
let showError = () => {
  console.log("error");
}

console.log("---------");

const sayHello1 = function (name) {
  const msg = `Hello, ${name}`;
  console.log(msg);
}

sayHello1(`Jung`);

console.log("-----화살표 함수 변경----");

const sayHello2 = (name) => {
  const msg = `Hello, ${name}`;
  console.log(msg);
}

sayHello2(`Jung`);

console.log("---------");

const add = function (num1, num2) {
  const result = num1 + num2;
  return result;
}

console.log(add(5,6));

console.log("-----화살표 함수 변경----");

const add2 = (num1, num2) => {
  const result = num1 + num2;
  return result;
}

console.log(add2(5,6));

console.log("----return 함수-----");

const add3 = (num1, num2) => {
  return num1 + num2;
}

console.log(add3(5,6));

console.log("----return, 괄호 지우기-----");

const add4 = (num1, num2) => (num1 + num2);

console.log(add4(5,6));

console.log("----괄호 지우기-----");

const add5 = (num1, num2) => num1 + num2;

console.log(add5(5,6));

// //객체(Object)
// const superman={
//   name:'clark',
//   age:33,
//   hairColor:'black',
//   gender:'male',
// }

// //접근
// superman.name // 'clark'
// superman['age'] //33

// //추가
// superman.gender='male';
// superman['hairColor']='black';

// //삭제
// delete superman.hairColor;


//객체ex

const superman = {
    name : 'clark',
    age : 30,
  }
  
  superman.hairColor = 'black';
  superman['hobby'] = 'football';
  console.log(superman)
  delete superman.age;
  
  function makeObject(name, age){
    return {
      name,
      age,
      hobby : 'football'
    }
  }
  
  const Mike = makeObject('Mike', 30);
  console.log(Mike)
  
  console.log("age" in Mike)
  console.log("birthday" in Mike);
  
  function isAdult(user){
    if(!('age' in user) || // user에 age가 없거나
       user.age < 20) { // 20살 미만이거나
      return false;
    } else
      return true;
  }
  
  const Mickey = {
    name : "Mickey",
    age : 30
  }; 
  
  const Jane = {
    name : "Jane"
  };
  
  console.log(isAdult(Mickey))
  
  // 객체 for ... in
  
  const Jae = {
    name : "Jae",
    age : 33,
    hobby : "basket ball",
  };
  
  for(x in Jae) {
    console.log(Jae[x]) // Jae['age']
  }
  
  // x는 값이 출력되는 것

  //연습 13번

  function convertScoreToGradeWithPlusAndMinus(score) {
    // TODO: 여기에 코드를 작성합니다.
    if(score > 100 || score < 0) {
      return 'INVALID SCORE'
    }
    if(score === 100) {
      return 'A+';
    }
    if(score < 60) {
      return 'F';
    }
    let num1, num2, gd, pm;
    //gd - grade , pm - 플마
    num1 = parseInt(score / 10);
    num2 = score % 10;
    
    if(num1=== 6) {
      gd = 'D';
    } else if(num1 === 7) {
      gd = 'C';
    } else if(num1 === 8) {
      gd = 'B';
    } else if(num1 === 9) {
      gd = 'A';
    }
  
    if (num2 % 10 >= 0 && num2 % 10 <=2) {
      pm = '-';
    } else if(num2 % 10 >= 3 && num2 % 10 <=7) {
      pm = '';
    } else if(num2 % 10 >= 8 && num2 % 10 <=9) {
      pm = '+';
    }
    return gd + pm;
  }
  