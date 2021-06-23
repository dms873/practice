"use strict";

// Promise is a JavaScript object for asynchronous operation.
// state: pending -> fulfilled or rejected
// Producer vs Consumer

// 1. Producer
// when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
    // doing some heavy work (network, read files)
    console.log("doing something...");
    setTimeout(() => {
        // resolve("Jinny");
        reject(new Error("no network"));
    }, 2000);
});

// 2. Consumers: then, catch, finally
promise //
    .then((value) => {
        console.log(value); // Jinny
    })
    .catch((error) => {
        console.log(error);
    })
    .finally(() => {
        console.log("finally");
    });

// 3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => resolve(1), 1000);
});

fetchNumber //
    .then((num) => num * 2) // 1*1 = 2
    .then((num) => num * 3) // 2*3 = 6
    .then((num) => {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(num - 1), 1000); // 6-1 = 5
        });
    })
    .then((num) => console.log(num)); // 5

// 4. Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve("🐓"), 1000);
    });
const getEgg = (hen) =>
    new Promise((resolve, reject) => {
        setTimeout(() => reject(new Error(`error! ${hen} => 🥚`)), 1000);
    });
const cook = (egg) =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => 🍳`), 1000);
    });

getHen()
    .then((hen) => getEgg(hen)) // 1가지만 받아서 그대로 전달하는 경우에는 .then(getEgg)로 줄일 수 있다
    .catch((error) => {
        return "🍗";
    })
    .then((egg) => cook(egg)) // .then(cook)
    .then((meal) => console.log(meal)) // .then(console.log)
    .catch(console.log);

// !코딩앙마!
const pr = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("OK");
    }, 3000);
});

pr.then(
    function (result) {
        console.log(result + " 가지러 가자.");
    },
    function (err) {
        console.log("다시 주문해주세요..");
    }
);

// ex1)
const pr = new Promise((resolve, reject) => {
    setTimeout(() => {
        // resolve("OK");
        reject(new Error("err..."));
    }, 1000);
});

console.log("시작");
pr.then((result) => {
    console.log(result);
})
    .catch((err) => {
        console.log(err);
    })
    .finally(() => {
        console.log("끝");
    });

// ex2) 콜백 지옥
const f1 = (callback) => {
    setTimeout(function () {
        console.log("1번 주문 완료");
        callback();
    }, 1000);
};

const f2 = (callback) => {
    setTimeout(function () {
        console.log("2번 주문 완료");
        callback();
    }, 3000);
};

const f3 = (callback) => {
    setTimeout(function () {
        console.log("3번 주문 완료");
        callback();
    }, 2000);
};

console.log("시작");
f1(function () {
    f2(function () {
        f3(function () {
            console.log("끝");
        });
    });
});

// Promise Chaining

const f1 = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            // resolve("1번 주문 완료");
            reject(new Error("xx"));
        }, 1000);
    });
};

const f2 = (message) => {
    console.log(message);
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            reject("xxx");
        }, 3000);
    });
};

const f3 = (message) => {
    console.log(message);
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("3번 주문 완료");
        }, 2000);
    });
};

// Promise.race
// 하나만 resolve되면 그 resolve를 리턴한다.
console.time("x");
Promise.race([f1(), f2(), f3()]) //
    .then((resolve) => {
        console.log(resolve);
        console.timeEnd("x");
    });

// Promise.all(3초 소요)
// 다 보여주거나, 다 안보여줄때 사용한다.
console.time("x");
Promise.all([f1(), f2(), f3()]) //
    .then((resolve) => {
        console.log(resolve);
        console.timeEnd("x");
    });

// 6초 소요
// console.log("시작");
// f1()
//     .then((resolve) => f2(resolve))
//     .then((resolve) => f3(resolve))
//     .then((resolve) => console.log(resolve))
//     .catch(console.log)
//     .finally(() => {
//         console.log("끝");
//     });
