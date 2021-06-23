// async & await
// clear style of using promise :)

// 1. async
async function fetchUser() {
    // do network request in 10 secs...
    resolve("Jinny");
}

const user = fetchUser();
user.then(console.log);
console.log(user);

// 2. await
function delay(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(3000);
    throw "error";
    return "사과";
}

async function getBanana() {
    await delay(3000);
    return "바나나";
}

function pickFruits() {
    const applePromise = getApple();
    const bananaPromise = getBanana();
    const apple = await applePromise;
    const banana = await bananaPromise;
    return `${apple} + ${banana}`;
}

pickFruits().then(console.log);

// 3. useful Promise APIs
function pickAllFruits() {
    return Promise.all([getApple(), getBanana()]).then((fruits) =>
        fruits.join(" + ")
    );
}

pickAllFruits().then(console.log);

function pickOnlyOne() {
    return Promise.race([getApple(), getBanana()]);
}

pickOnlyOne().then(console.log);

// !코딩앙마!

const f1 = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("1번 주문 완료");
        }, 1000);
    });
};

const f2 = (message) => {
    console.log(message);
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            reject(new Error("err..."));
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

f1()
    .then((resolve) => f2(resolve))
    .then((resolve) => f3(resolve))
    .then((resolve) => console.log(resolve))
    .catch(console.log);

console.log("시작");
async function order() {
    try {
        const result1 = await f1();
        const result2 = await f2(result1);
        const result3 = await f3(result2);
        console.log(result3);
    } catch (e) {
        console.log(e);
        console.log("종료");
    }
}

async function getName() {
    // return "Mike";
    // return Promise.resolve('Tom')
    throw new Error("err...");
}

getName().catch((err) => {
    console.log(err);
});

// await
function getName(name) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(name);
        }, 1000);
    });
}

async function showName() {
    const result = await getName("Mike");
    console.log(result);
}

console.log("시작");
showName();
