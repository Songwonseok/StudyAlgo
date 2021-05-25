const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split("\n");

const calculate = (str) => {
    const operators = ['+', '-'];
    let index = 0;
    let left = str[index++];

    while(index < str.length && operators.indexOf(str[index]) === -1) {
        left += str[index++];
    }
    
    left = parseInt(left);

    while(index < str.length){
        let op = str[index++];
        let right = str[index++];

        while(index < str.length && operators.indexOf(str[index]) === -1){
            right += str[index++];
        }
        
        if(op === '+'){
            left += parseInt(right);
        }else{
            left -= parseInt(right);
        }
    }
    
    return left;
}

const dfs = (N, curr, acc, answers) => {
    if(curr === N -1) {
        acc.push(N);

        const str = acc.join('');

        if(calculate(str.replace(/ /g, "")) === 0){
            answers.push(str);
        }
        return;
    }

    dfs(N, curr+1, [...acc, curr+1, ' '], answers);
    dfs(N, curr+1, [...acc, curr+1, '+'], answers);
    dfs(N, curr+1, [...acc, curr+1, '-'], answers);
    

}

(() => {
    inputs.shift();
    
    inputs.forEach(N => {
        const answers = [];
        dfs(N, 0, [], answers);
        console.log(answers.join("\n") + "\n");
    });

})();
