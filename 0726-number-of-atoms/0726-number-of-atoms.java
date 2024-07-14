/** 
겁나 지저분한 구현문제...

차근차근 정리해야한다.
규칙
화학기호 이름은 대문자로 시작하며 이름이 2자 이상인경우 소문자로 끝난다. (H, Mg, Cu)
화학기호 옆에는 구성된 화학기호가 2개 이상인 경우 숫자가 추가로 입력된다. (H2O, O2)
괄호의 경우도 있다. 그럼 괄호 밖의 숫자를 통해 그 안의 모든 화학 기호를 곱해야 한다. ex. (SO3)2 -> S2O6
formula 입력방식은 항상 올바르다. 즉, 입력받은 화학기호의 오류여부는 확인 안해도 된다.

fomular를 순회하고, case 별로 규칙에 맞게 맵을 구성하여 알파뱃 순서에 맞게 각 화학기호와 화학 구성의 수만큼 출력해야한다.
코드가 지저분해질 수 밖에 없으므로 case를 잘 나눠야 한다.

case 별로 연산을 처리하고 {화학기호 : 갯수}로 구성된 map을 리턴시킨다.

이름을 담을 문자열 변수 선언
갯수를 담을 문자열 변수 선언
'문자열, 정수' 로 구성된 맵 선언
fomular를 순회한다.
(fomular[i]는 '대문자', '소문자', '숫자', '('', ')' 별로 case를 나눈다.)
(case별로 처리해야하는 방식이 매우 상이하므로 for가 아닌 while과 index 변수로 진행)
인덱스(gloabl)
파싱(formular):
    case1. 대문자
        이름 변수가 비어있다? 이름변수 입력
        이름 변수가 이미 있다?
            이미 입력된 이름 변수가 대문자인 경우이다. 따라서,
            기존 이름 변수를 화학기호로 할당.
            갯수 변수가 비어있지 않다면 갯수로 할당. 비어있다면 1개로 할당
            맵에 화학기호 : 갯수를 갱신한다.
            fomular[i]를 이름 변수에 담는다.
        인덱스++
    case2. 소문자
        (formula 입력 포맷은 항상 유효하므로 오류는 따로 체크하지 않는다.)
        이름 변수에 해당 소문자를 추가
        인덱스++
    case3. 숫자
        갯수 문자열에 숫자 추가
        인덱스++
    case4. (
        (괄호 안의 화학기호들의 nested 된 괄호가까지 고려해야한다.. stack 보다는 차라리 재귀가 더 괜찮을 것 같다.)
        인덱스++ ('(' 부분은 문자열 입력대상이 아님)
        중첩맵 = 파싱(fomular)
        기존맵에 중첩맵 내용 갱싱
    case5. )
        (화학기호의 갯수들을 곱하기를 수행해줘야한다. 현재 함수에 선언된 맵을 기준으로 곱하기를 진행하면 재귀가 진행되어도 문제없이 곱하기 수행은 될 것 같다.)
        인덱스++ (')' 기호 스킵)
        곱숫자 선언
        fomular[i]가 숫자일때까지:
            곱숫자 갱신
            인덱스++
        맵 순회하여 각 맵의 값 * 곱숫자
    
    마지막으로 이름, 갯수 변수 확인하여 맵 데이터 갱신
    맵 리턴

    맵을 정렬한다.
    맵을 순회하여 문자열에 이름갯수를 순차적으로 입력한다.
    문자열 리턴

    ps. 겁나 복잡하다..ㅠ
    ps. StringBuilder로 문자열을 쌓을 경우 해당 sb를 toString()으로 변경시켜줘야한다.
*/
class Solution {
    private int index = 0;

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = parse(formula);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        StringBuilder result = new StringBuilder();
        for (String atom : sortedMap.keySet()) {
            result.append(atom);
            int count = sortedMap.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    private Map<String, Integer> parse(String formula) {
        Map<String, Integer> curr = new HashMap<>();
        StringBuilder name = new StringBuilder();
        StringBuilder count = new StringBuilder();

        while (index < formula.length()) {
            if (Character.isUpperCase(formula.charAt(index))) {
                if (name.length() > 0) {
                    if (count.length() == 0) {
                        curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + 1);
                    } else {
                        curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + Integer.parseInt(count.toString()));
                    }
                }
                name = new StringBuilder();
                name.append(formula.charAt(index));
                count = new StringBuilder();
                index++;
            } else if (Character.isLowerCase(formula.charAt(index))) {
                name.append(formula.charAt(index));
                index++;
            } else if (Character.isDigit(formula.charAt(index))) {
                count.append(formula.charAt(index));
                index++;
            } else if (formula.charAt(index) == '(') {
                index++;
                Map<String, Integer> inner = parse(formula);
                for (String atom : inner.keySet()) {
                    curr.put(atom, curr.getOrDefault(atom, 0) + inner.get(atom));
                }
            } else if (formula.charAt(index) == ')') {
                if (name.length() > 0) {
                    if (count.length() == 0) {
                        curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + 1);
                    } else {
                        curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + Integer.parseInt(count.toString()));
                    }
                }

                index++;
                StringBuilder multiplier = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                if (multiplier.length() > 0) {
                    int mult = Integer.parseInt(multiplier.toString());
                    for (String atom : curr.keySet()) {
                        curr.put(atom, curr.get(atom) * mult);
                    }
                }
                return curr;
            }
        }

        if (name.length() > 0) {
            if (count.length() == 0) {
                curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + 1);
            } else {
                curr.put(name.toString(), curr.getOrDefault(name.toString(), 0) + Integer.parseInt(count.toString()));
            }
        }

        return curr;
    }
}