package walmart.cqconnector.services;

import walmart.cqconnector.models.TrialModel;

public interface TrialService {
  public boolean savetoDb(TrialModel data);
}
