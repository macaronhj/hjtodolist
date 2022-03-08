package first.project.todolist.login.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, MemberDto> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public MemberDto save(MemberDto memberDto){
        memberDto.setMemberSeq(++sequence);
        log.info("save:memberDto={}", memberDto);
        store.put(memberDto.getMemberSeq(),memberDto);
        return memberDto;
    }

    public MemberDto findByseq(Long memberSeq){
        return store.get(memberSeq);
    }

    public Optional<MemberDto> findByEmail(String email){
        return this.findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

    public List<MemberDto> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clearStore() {
        store.clear();
    }
}
