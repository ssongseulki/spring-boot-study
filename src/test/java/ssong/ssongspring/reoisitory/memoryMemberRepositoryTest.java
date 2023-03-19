package ssong.ssongspring.reoisitory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ssong.ssongspring.domain.Member;
import ssong.ssongspring.repository.MemoryMemberRepository;

import java.sql.SQLOutput;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class memoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("뚜기");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
       // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("뚜기1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("뚜기2");
        repository.save(member2);

        Member result = repository.findByName("뚜기1").get();
        assertThat(result).isEqualTo(member1);
        System.out.println("result = " + (result == member1));
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("뚜기1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("뚜기1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
        System.out.println(result);

    }
}
