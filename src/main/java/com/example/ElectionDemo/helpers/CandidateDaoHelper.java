package com.example.ElectionDemo.helpers;

import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.dto.ItemParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public CandidateDto updateCandidateDto(CandidateDto currentDto, Map<String, String[]> params) {
        for (String name : params.keySet()) {
            if(name == null) continue;

            String fixedName = name.toLowerCase();
            switch (fixedName) {
                case "fullname":
                    currentDto.setFullName(params.get(name)[0]);
                    break;
                case "currentjob":
                    currentDto.setCurrentJob(params.get(name)[0]);
                    break;
                case "about":
                    currentDto.setAbout(params.get(name)[0]);
                    break;
                default:
                    if(fixedName.contains("key-")) {
                        String key = params.get(name)[0];
                        currentDto.getParams().forEach(itemParam -> {
                            if (itemParam.getKey().equalsIgnoreCase(key)) {
                                String val = params.get("value-" + name.substring(name.lastIndexOf("-") + 1))[0];
                                itemParam.setValue(val);
                            }
                        });
                    }
            }
        }

        return currentDto;
    }
}
