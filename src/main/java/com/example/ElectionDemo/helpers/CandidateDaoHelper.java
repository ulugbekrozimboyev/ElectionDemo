package com.example.ElectionDemo.helpers;

import com.example.ElectionDemo.dto.CandidateDto;

import java.util.HashMap;
import java.util.Map;

/**
 * CandidateDaoHelper - singleton helper class for CandidateDao
 *
 * Pros:
 *  Thread safety is guaranteed
 *  Client application can pass arguments
 *  Lazy initialization achieved
 *  Synchronization overhead is minimal and applicable only for first few threads when the variable is null.
 *
 * Cons:
 *  Extra if condition
 */
public class CandidateDaoHelper {
    private static volatile CandidateDaoHelper instance;
    private static final Object mutex = new Object();

    private CandidateDaoHelper() {
    }

    public static CandidateDaoHelper getInstance() {
        CandidateDaoHelper result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) instance = result = new CandidateDaoHelper();
            }
        }
        return result;
    }

    public CandidateDto updateCandidateDto(Map<String, String[]> params) {
        HashMap<String, String> info = new HashMap<>();
        CandidateDto candidateDto = new CandidateDto();

        for (String name : params.keySet()) {

            if(name == null) continue;

            String fixedName = name.toLowerCase();
            switch (fixedName) {
                case "fullname":
                    candidateDto.setFullName(params.get(fixedName)[0]);
                    break;
                case "currentjob":
                    candidateDto.setCurrentJob(params.get(fixedName)[0]);
                    break;
                case "about":
                    candidateDto.setAbout(params.get(fixedName)[0]);
                    break;
                default:
                    if(fixedName.contains("key-")) {
                        info.put(
                            params.get(name)[0],
                            params.get("value-" + name.substring(name.lastIndexOf("-") + 1))[0]
                        );
                    }
            }
        }

        candidateDto.setMoreInformation(info);
        return candidateDto;
    }
}
