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
        setTimeout(() => resolve("π"), 1000);
    });
const getEgg = (hen) =>
    new Promise((resolve, reject) => {
        setTimeout(() => reject(new Error(`error! ${hen} => π₯`)), 1000);
    });
const cook = (egg) =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => π³`), 1000);
    });

getHen()
    .then((hen) => getEgg(hen)) // 1κ°μ§λ§ λ°μμ κ·Έλλ‘ μ λ¬νλ κ²½μ°μλ .then(getEgg)λ‘ μ€μΌ μ μλ€
    .catch((error) => {
        return "π";
    })
    .then((egg) => cook(egg)) // .then(cook)
    .then((meal) => console.log(meal)) // .then(console.log)
    .catch(console.log);

// !μ½λ©μλ§!
const pr = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("OK");
    }, 3000);
});

pr.then(
    function (result) {
        console.log(result + " κ°μ§λ¬ κ°μ.");
    },
    function (err) {
        console.log("λ€μ μ£Όλ¬Έν΄μ£ΌμΈμ..");
    }
);

// ex1)
const pr = new Promise((resolve, reject) => {
    setTimeout(() => {
        // resolve("OK");
        reject(new Error("err..."));
    }, 1000);
});

console.log("μμ");
pr.then((result) => {
    console.log(result);
})
    .catch((err) => {
        console.log(err);
    })
    .finally(() => {
        console.log("λ");
    });

// ex2) μ½λ°± μ§μ₯
const f1 = (callback) => {
    setTimeout(function () {
        console.log("1λ² μ£Όλ¬Έ μλ£");
        callback();
    }, 1000);
};

const f2 = (callback) => {
    setTimeout(function () {
        console.log("2λ² μ£Όλ¬Έ μλ£");
        callback();
    }, 3000);
};

const f3 = (callback) => {
    setTimeout(function () {
        console.log("3λ² μ£Όλ¬Έ μλ£");
        callback();
    }, 2000);
};

console.log("μμ");
f1(function () {
    f2(function () {
        f3(function () {
            console.log("λ");
        });
    });
});

// Promise Chaining

const f1 = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            // resolve("1λ² μ£Όλ¬Έ μλ£");
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
            resolve("3λ² μ£Όλ¬Έ μλ£");
        }, 2000);
    });
};

// Promise.race
// νλλ§ resolveλλ©΄ κ·Έ resolveλ₯Ό λ¦¬ν΄νλ€.
console.time("x");
Promise.race([f1(), f2(), f3()]) //
    .then((resolve) => {
        console.log(resolve);
        console.timeEnd("x");
    });

// Promise.all(3μ΄ μμ)
// λ€ λ³΄μ¬μ£Όκ±°λ, λ€ μλ³΄μ¬μ€λ μ¬μ©νλ€.
console.time("x");
Promise.all([f1(), f2(), f3()]) //
    .then((resolve) => {
        console.log(resolve);
        console.timeEnd("x");
    });

// 6μ΄ μμ
// console.log("μμ");
// f1()
//     .then((resolve) => f2(resolve))
//     .then((resolve) => f3(resolve))
//     .then((resolve) => console.log(resolve))
//     .catch(console.log)
//     .finally(() => {
//         console.log("λ");
//     });
