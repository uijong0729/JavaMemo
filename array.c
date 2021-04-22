#include <stdio.h>
#include <stddef.h>
#include <assert.h>

// 자료구조 기초
/*
	배열(ArrayList)
		- 각 자료는 색인(index)으로 접근
		- 연속된 메모리나 각 요소의 실제 메모리 상의 위치를 쉽게 찾을 수 있음
		- 위치 = 시작주소 + sizeof(자료형) * 색인;
*/
enum { MAX_NUMS = 8 };
enum { INVALID_INDEX = -1};
int s_nums[MAX_NUMS];
size_t s_num_count = 0;

// 배열의 삽입 
void insert_at(size_t index, int n) 
{
	size_t i;

	assert(index <= s_num_count);
	assert(s_num_count < MAX_NUMS);

	// i : 시작하는 인덱스, s_num_count : 현재 배열위치, index 삽입하고자 하는 위치
	// 데이터를 넣을 자리에 데이터가 있다면 기존 요소들이 뒤로 한칸씩 밀림 
	// 옮길 땐 맨 뒤에 것부터 옮김
	for (i = s_num_count; i > index; --i) {
		s_nums[i] = s_nums[i - 1];
	}

	// 미는 작업이 완료되었으면 값 삽입
	s_nums[index] = n;
	++s_num_count;
}

// 배열의 삭제
void remove_at(size_t index) 
{
	size_t i;

	assert(index < s_num_count);

	--s_num_count;
	for (i = index; i < s_num_count; i++) {
		s_nums[i] = s_nums[i + 1];
	}
}
//배열의 검색은 처음부터 차례대로 방문하여 값을 확인 (없으면 -1을 반환)
//색인을 이미 알고 있다면 곧바로 접근 가능하기 때문에 시간복잡도가 O(1)이 되는 초고속연산이 가능하다.
//배열의 제일 뒤에 데이터를 삽입하는 경우는 시간복잡도가 O(1)

// <빠른배열>
//	배열속의 데이터가 중요하지 않은경우, 배열 속 데이터를 삭제했을 때 맨 뒤 데이터를 삭제된 공간에 삽입하면 
//	배열의 요소를 삭제했을때의 시간복잡도는 O(1)이 된다.

//  갑자기 생각난 ArrayList에 대한 메모 
/*
	ArrayList에서 특정 요소 제거

	//3번째 요소를 제거하는 법? : 순서가 중요하지 않다면 마지막 요소를 3번째에 삽입
	//뒷 데이터를 앞으로 당길 필요없어진다.
	list.set(2, list.get(list.size()-1));
	
*/

int main(void)
{
	insert_at(0, 1);
	printf("%d", s_nums[0]);

	insert_at(0, 2);
	printf("%d", s_nums[0]);
	printf("%d", s_nums[1]);

	printf("\n");

	remove_at(0);
	remove_at(0);
	printf("%d", s_nums[0]);
	return 0;
}


