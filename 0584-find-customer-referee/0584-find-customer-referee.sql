# Write your MySQL query statement below
# MySQL에서 특정 컬럼의 존재 혹은 일치여부를 판단할 때, 'three-value logic'에 기반한다.
# TRUE, FALSE 뿐만 아니라 UNKNOWN 이라는 값도 있다. UNKNOWN은 주로 조건절의 컬럼이 null 인 경우도 포함한다.
select name from customer where  referee_id != 2 or referee_id is null;