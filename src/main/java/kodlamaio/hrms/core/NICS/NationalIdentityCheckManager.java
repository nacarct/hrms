package kodlamaio.hrms.core.NICS;

import org.springframework.stereotype.Service;

@Service
public class NationalIdentityCheckManager implements NationalIdentityCheckService{
    @Override
    public boolean checkNationalIdentity(String identity) {
        if (identity.length()==11)
            return true;

        return false;
    }
}
